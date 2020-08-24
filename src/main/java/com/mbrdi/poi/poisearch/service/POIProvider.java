package com.mbrdi.poi.poisearch.service;

import com.mbrdi.poi.geosearch.dtos.GeoPosition;
import com.mbrdi.poi.poisearch.dtos.POILocationDetails;
import java.util.List;
import java.util.concurrent.CompletableFuture;


public interface POIProvider {


  public CompletableFuture<List<POILocationDetails>> getPOILocationDetails(GeoPosition position) throws Exception;
}
