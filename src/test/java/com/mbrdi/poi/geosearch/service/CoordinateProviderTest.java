package com.mbrdi.poi.geosearch.service;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.mbrdi.poi.exception.GeoSearchException;
import com.mbrdi.poi.geosearch.dtos.GeoPosition;
import com.mbrdi.poi.geosearch.stubs.CoordinateProviderTestStub;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@RunWith(JUnit4.class)
public class CoordinateProviderTest {

  private RestTemplate restTemplate = mock(RestTemplate.class);
  private CoordinateProvider coordinateProvider= new CoordinateProvider(restTemplate,
      CoordinateProviderTestStub.discoverApi,CoordinateProviderTestStub.accessToke);

  @Test
  public void testGetValidPositionCooordinates() throws Exception{
    when(restTemplate.exchange(any(String.class),any(HttpMethod.class),any(HttpEntity.class),any(
        ParameterizedTypeReference.class))).thenReturn(CoordinateProviderTestStub.getValidGeoCoordinateResponseEntity());
    GeoPosition actualGeoPosition = coordinateProvider.findCoordinatesOfLocation(CoordinateProviderTestStub.getValidLocation());
    Assert.assertEquals(CoordinateProviderTestStub.getValidGeoPosition(),actualGeoPosition);
  }

  @Test
  public void testGetInValidPositionCooordinates() throws Exception{
    when(restTemplate.exchange(any(String.class),any(HttpMethod.class),any(HttpEntity.class),any(
        ParameterizedTypeReference.class))).thenReturn(CoordinateProviderTestStub.getInValidGeoCoordinateResponseEntity());
    GeoPosition actualGeoPosition = coordinateProvider.findCoordinatesOfLocation(CoordinateProviderTestStub.getInvalidLocation());
    Assert.assertEquals(new GeoPosition(),actualGeoPosition);
  }

  @Test(expected = GeoSearchException.class)
  public void testException(){
    when(restTemplate.exchange(any(String.class),any(HttpMethod.class),any(HttpEntity.class),any(
        ParameterizedTypeReference.class))).thenThrow(new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
    GeoPosition actualGeoPosition = coordinateProvider.findCoordinatesOfLocation(CoordinateProviderTestStub.getInvalidLocation());
    Assert.assertEquals(new GeoPosition(),actualGeoPosition);
  }

}
