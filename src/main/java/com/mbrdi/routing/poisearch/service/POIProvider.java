package com.mbrdi.routing.poisearch.service;

import com.mbrdi.routing.geosearch.dtos.GeoPosition;
import com.mbrdi.routing.poisearch.dtos.POILocationDetails;
import java.util.List;
import java.util.concurrent.CompletableFuture;


public interface POIProvider {


  public CompletableFuture<List<POILocationDetails>> getPOILocationDetails(GeoPosition position) throws Exception;
}
