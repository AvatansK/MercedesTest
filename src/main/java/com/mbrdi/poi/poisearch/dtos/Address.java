package com.mbrdi.poi.poisearch.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

  private String label;
  private String countryCode;
  private String countryName;
  private String state;
  private String county;
  private String city;
  private String district;
  private String street;
  private String postalCode;
  private String houseNumber;
}
