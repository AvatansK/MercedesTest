package com.mbrdi.routing.geosearch.stubs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbrdi.routing.geosearch.dtos.GeoCoordinateResponse;
import com.mbrdi.routing.geosearch.dtos.GeoPosition;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CoordinateProviderTestStub {

  private static ObjectMapper objectMapper = new ObjectMapper();
  public static String discoverApi = "https://geocode.search.hereapi.com/v1/geocode";
  public static String accessToke = "accessToken";

  public static String getInvalidLocation(){
    return "yyyyyy";
  }

  public static String getValidLocation(){
    return "berlin";
  }

  public static GeoPosition getValidGeoPosition(){
    GeoPosition geoPosition = new GeoPosition();
    geoPosition.setLat("52.51604");
    geoPosition.setLng("13.37691");
    return geoPosition;
  }

  public static ResponseEntity getValidGeoCoordinateResponseEntity() throws Exception{
    return new ResponseEntity<>(validGeoCordinateResponseBody(), HttpStatus.OK);
  }

  public static GeoCoordinateResponse validGeoCordinateResponseBody()throws Exception{
    return objectMapper.readValue(geoCoordinatesResponseString,GeoCoordinateResponse.class);
  }

  public static ResponseEntity getInValidGeoCoordinateResponseEntity() throws Exception{
    return new ResponseEntity<>(invalidGeoCordinateResponseBody(), HttpStatus.OK);
  }

  public static GeoCoordinateResponse invalidGeoCordinateResponseBody()throws Exception{
    return objectMapper.readValue(invalidGeoCoordinateResponseString,GeoCoordinateResponse.class);
  }

  public static String geoCoordinatesResponseString = "{\n"
      + "  \"items\": [\n"
      + "    {\n"
      + "      \"title\": \"Berlin, Deutschland\",\n"
      + "      \"id\": \"here:cm:namedplace:20187403\",\n"
      + "      \"resultType\": \"locality\",\n"
      + "      \"localityType\": \"city\",\n"
      + "      \"address\": {\n"
      + "        \"label\": \"Berlin, Deutschland\",\n"
      + "        \"countryCode\": \"DEU\",\n"
      + "        \"countryName\": \"Deutschland\",\n"
      + "        \"state\": \"Berlin\",\n"
      + "        \"county\": \"Berlin\",\n"
      + "        \"city\": \"Berlin\",\n"
      + "        \"postalCode\": \"10117\"\n"
      + "      },\n"
      + "      \"position\": {\n"
      + "        \"lat\": 52.51604,\n"
      + "        \"lng\": 13.37691\n"
      + "      },\n"
      + "      \"mapView\": {\n"
      + "        \"west\": 13.08835,\n"
      + "        \"south\": 52.33812,\n"
      + "        \"east\": 13.761,\n"
      + "        \"north\": 52.6755\n"
      + "      },\n"
      + "      \"scoring\": {\n"
      + "        \"queryScore\": 1.0,\n"
      + "        \"fieldScore\": {\n"
      + "          \"city\": 1.0\n"
      + "        }\n"
      + "      }\n"
      + "    }\n"
      + "  ]\n"
      + "}";

  public static String invalidGeoCoordinateResponseString = "{\"items\":[]}";

}
