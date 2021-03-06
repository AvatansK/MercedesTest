package com.mbrdi.poi.poisearch.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mbrdi.poi.geosearch.dtos.GeoPosition;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class POILocationDetails {

  private GeoPosition position;
  private String title;
  private Integer distance;
  private List<Timing> openingHours;
}
