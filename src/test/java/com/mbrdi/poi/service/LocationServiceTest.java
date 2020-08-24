package com.mbrdi.poi.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.mbrdi.poi.dtos.LocationPOIResponse;
import com.mbrdi.poi.geosearch.dtos.GeoPosition;
import com.mbrdi.poi.geosearch.service.CoordinateProvider;
import com.mbrdi.poi.geosearch.stubs.CoordinateProviderTestStub;
import com.mbrdi.poi.poisearch.service.impl.ChargingStationProvider;
import com.mbrdi.poi.poisearch.service.impl.ParkingSpotProvider;
import com.mbrdi.poi.poisearch.service.impl.RestrauntProvider;
import com.mbrdi.poi.poisearch.stub.ChargingStationProviderTestStub;
import com.mbrdi.poi.poisearch.stub.ParkingSpotProviderTestStub;
import com.mbrdi.poi.poisearch.stub.RestrauntProviderTestStub;
import com.mbrdi.poi.service.stub.LocationServiceTestStub;
import java.util.concurrent.CompletableFuture;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LocationServiceTest {

  private CoordinateProvider coordinateProvider = mock(CoordinateProvider.class);
  private ChargingStationProvider chargingStationProvider = mock(ChargingStationProvider.class);
  private RestrauntProvider restrauntProvider = mock(RestrauntProvider.class);
  private ParkingSpotProvider parkingSpotProvider = mock(ParkingSpotProvider.class);
  private LocationService locationService = new LocationService(coordinateProvider,chargingStationProvider,
      restrauntProvider,parkingSpotProvider);

  @Test
  public void testValidLocationPOIResponse() throws Exception{
    when(coordinateProvider.findCoordinatesOfLocation(any(String.class))).thenReturn(
        CoordinateProviderTestStub.getValidGeoPosition());
    when(chargingStationProvider.getPOILocationDetails(any(GeoPosition.class))).thenReturn(
        CompletableFuture.completedFuture(ChargingStationProviderTestStub.validChargingStationsResponseBody().getItems()));
    when(restrauntProvider.getPOILocationDetails(any(GeoPosition.class))).thenReturn(
        CompletableFuture.completedFuture(RestrauntProviderTestStub.validRestaurantsResponseBody().getItems()));
    when(parkingSpotProvider.getPOILocationDetails(any(GeoPosition.class))).thenReturn(
        CompletableFuture.completedFuture(ParkingSpotProviderTestStub.validParkingSpotResponseBody().getItems()));
    LocationPOIResponse actualResponse = locationService.getNearestPOIDetails(CoordinateProviderTestStub.getValidLocation());
    Assert.assertEquals(LocationServiceTestStub.getValidLocationPOIResponse(),actualResponse);
  }

}
