package com.mbrdi.routing.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mbrdi.routing.poisearch.dtos.POILocationDetails;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationPOIResponse {

  private List<POILocationDetails> restaurantPOI;
  private List<POILocationDetails> chargingStationPOI;
  private List<POILocationDetails> parkingSpotPOI;
}
