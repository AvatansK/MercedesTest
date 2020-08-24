package com.mbrdi.poi.poisearch.service.impl;

import com.mbrdi.poi.exception.POISearchException;
import com.mbrdi.poi.geosearch.dtos.GeoPosition;
import com.mbrdi.poi.poisearch.dtos.POIFinderResponse;
import com.mbrdi.poi.poisearch.dtos.POILocationDetails;
import com.mbrdi.poi.poisearch.service.POIProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class RestrauntProvider implements POIProvider {

  private RestTemplate restTemplate;
  private String discoverApi;
  private String accessToken;
  private String categoryType;

  @Autowired
  RestrauntProvider(RestTemplate restTemplate,@Value("${here-map.discover-api}") String discoverApi,
      @Value("${here-map.api-key}")String accessToken,
      @Value("${here-map.restraunt-category-type}")String categoryType){
    this.restTemplate=restTemplate;
    this.discoverApi=discoverApi;
    this.accessToken=accessToken;
    this.categoryType=categoryType;
  }

  @Async("poiAsyncExecutor")
  public CompletableFuture<List<POILocationDetails>> getPOILocationDetails(GeoPosition position){
    List<POILocationDetails> poiDetails = new ArrayList<>();
    try{
      log.info("Finding Parking Spot for position long: {} and lat :{}",position.getLat(),position.getLng());
      String url = discoverApi+position.getLat()+","+position.getLng()
        +"&q="+categoryType+"&apiKey="+accessToken;
      ParameterizedTypeReference<POIFinderResponse> responseParameterizedTypeReference = new ParameterizedTypeReference<POIFinderResponse>() {};
      HttpEntity entity = new HttpEntity<>(null);
      POIFinderResponse response = restTemplate.exchange(url, HttpMethod.GET, entity, responseParameterizedTypeReference).getBody();
      if (response != null) {
        if (response.getItems()!=null && !response.getItems().isEmpty()) {
          poiDetails = response.getItems();
        }
        log.info("CoordinateProvider.findCoordinatesOfLocation:: Coordinates for " + position.getLng() + " : " + position.getLat());
      }
    } catch (Exception e) {
      log.error("Exception in finding restraunts ",e);
      throw  new POISearchException("Exception while getting restaurants poi",e);
    }
      return CompletableFuture.completedFuture(poiDetails);
  }
}
