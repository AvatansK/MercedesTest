package com.mbrdi.poi.service;

import com.mbrdi.poi.geosearch.dtos.GeoPosition;
import com.mbrdi.poi.geosearch.service.CoordinateProvider;
import com.mbrdi.poi.dtos.LocationPOIResponse;
import com.mbrdi.poi.poisearch.dtos.POILocationDetails;
import com.mbrdi.poi.poisearch.service.impl.ChargingStationProvider;
import com.mbrdi.poi.poisearch.service.impl.ParkingSpotProvider;
import com.mbrdi.poi.poisearch.service.impl.RestrauntProvider;
import com.mbrdi.poi.utilities.SearchFilterUtil;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LocationService {

  private CoordinateProvider coordinateProvider;
  private ChargingStationProvider chargingStationFinder;
  private RestrauntProvider restrauntFinder;
  private ParkingSpotProvider parkingSpotFinder;

  @Autowired
  LocationService(CoordinateProvider coordinateProvider, ChargingStationProvider chargingStationFinder,
      RestrauntProvider restrauntFinder, ParkingSpotProvider parkingSpotFinder){
    this.coordinateProvider = coordinateProvider;
    this.chargingStationFinder=chargingStationFinder;
    this.restrauntFinder=restrauntFinder;
    this.parkingSpotFinder=parkingSpotFinder;
  }

  @Cacheable(value="poiCache", key="#location")
  public LocationPOIResponse getNearestPOIDetails(String location) throws Exception{

    LocationPOIResponse locationPOIResponse = new LocationPOIResponse();
    GeoPosition position = coordinateProvider.findCoordinatesOfLocation(location);
    CompletableFuture<List<POILocationDetails>> chargingStationResponse = chargingStationFinder.getPOILocationDetails(position);
    CompletableFuture<List<POILocationDetails>> restrauntResponse = restrauntFinder.getPOILocationDetails(position);
    CompletableFuture<List<POILocationDetails>> parkingSpotResponse = parkingSpotFinder.getPOILocationDetails(position);
    locationPOIResponse.setChargingStationPOI(SearchFilterUtil.getNearestPOI(chargingStationResponse.get(),3));
    locationPOIResponse.setRestaurantPOI(SearchFilterUtil.getNearestPOI(restrauntResponse.get(),3));
    locationPOIResponse.setParkingSpotPOI(SearchFilterUtil.getNearestPOI(parkingSpotResponse.get(),3));
    return locationPOIResponse;
  }
}
