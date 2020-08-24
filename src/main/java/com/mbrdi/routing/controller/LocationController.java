package com.mbrdi.routing.controller;

import com.mbrdi.routing.dtos.LocationPOIResponse;
import com.mbrdi.routing.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/location")
public class LocationController {

  private LocationService locationService;

  @Autowired
  LocationController(LocationService locationService){
    this.locationService=locationService;
  }

  @GetMapping(value = "/nearest-poi")
  public ResponseEntity<LocationPOIResponse> getPosition(@RequestParam(name = "location", required = true) String location)
      throws Exception{
    LocationPOIResponse locationPOIResponse = locationService.getNearestPOIDetails(location);
    return new ResponseEntity<>(locationPOIResponse, HttpStatus.OK);

  }
}
