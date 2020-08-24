package com.mbrdi.routing.geosearch.service;

import com.mbrdi.routing.exception.GeoSearchException;
import com.mbrdi.routing.geosearch.dtos.GeoCoordinateResponse;
import com.mbrdi.routing.geosearch.dtos.GeoPosition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class CoordinateProvider {

  private RestTemplate restTemplate;
  private String geoCodeApiUrl;
  private String accessToken;

  @Autowired
  CoordinateProvider(RestTemplate restTemplate,@Value("${here-map.geocode-api}") String geoCodeApiUrl,
      @Value("${here-map.api-key}")String accessToken){
    this.restTemplate=restTemplate;
    this.geoCodeApiUrl=geoCodeApiUrl;
    this.accessToken=accessToken;
  }


  /**
   * Find the geographic coordinates for the given location using HERE map's geocode
   * API
   *
   * @param location
   * @return Coordinates
   */
  public GeoPosition findCoordinatesOfLocation(String location) {

    GeoPosition coordinates = new GeoPosition();
    try {
      log.info("CoordinateProvider.findCoordinatesOfLocation:: Invoking HERE Map Gecode API for a location : " + location);
      String url = geoCodeApiUrl + "?q=" + location+"&apiKey="+accessToken;
      HttpEntity entity = new HttpEntity<>(null);
      ParameterizedTypeReference<GeoCoordinateResponse> geoCoordinateResponseParameterizedTypeReference =
          new ParameterizedTypeReference<GeoCoordinateResponse>() {};
      GeoCoordinateResponse response = restTemplate.exchange(url, HttpMethod.GET, entity, geoCoordinateResponseParameterizedTypeReference).getBody();
      if (response != null) {
        if (response.getItems()!=null && !response.getItems().isEmpty()) {
          coordinates = response.getItems().get(0).getPosition();
        }
        log.info("CoordinateProvider.findCoordinatesOfLocation:: Coordinates for " + location + " : " + coordinates);
      }
    } catch (Exception e) {
      log.error("Exception in CoordinateProvider.findCoordinatesOfLocation:: " + e.getMessage());
      throw new GeoSearchException("Exception while getting coordinates for location"+location,e);
    }
    return coordinates;
  }

}
