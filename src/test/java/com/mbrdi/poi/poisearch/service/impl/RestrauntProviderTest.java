package com.mbrdi.poi.poisearch.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.mbrdi.poi.geosearch.stubs.CoordinateProviderTestStub;
import com.mbrdi.poi.poisearch.dtos.POILocationDetails;
import com.mbrdi.poi.poisearch.stub.RestrauntProviderTestStub;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@RunWith(JUnit4.class)
public class RestrauntProviderTest {

  private RestTemplate restTemplate = mock(RestTemplate.class);
  private ParkingSpotProvider parkingSpotProvider = new ParkingSpotProvider(restTemplate,
      RestrauntProviderTestStub.discoverApi,RestrauntProviderTestStub.accessToken,
      RestrauntProviderTestStub.categoryType);

  @Test
  public void testValidChargingPointsPOI() throws Exception{
    when(restTemplate.exchange(any(String.class),any(HttpMethod.class),any(HttpEntity.class),any(
        ParameterizedTypeReference.class))).thenReturn(RestrauntProviderTestStub.getValidRestaurantsResponse());
    CompletableFuture<List<POILocationDetails>> actualResponse = parkingSpotProvider.getPOILocationDetails(
        CoordinateProviderTestStub.getValidGeoPosition());
    Assert.assertEquals(RestrauntProviderTestStub.validRestaurantsResponseBody().getItems(),actualResponse.get());
  }

}
