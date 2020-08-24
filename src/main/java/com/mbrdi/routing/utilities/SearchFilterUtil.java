package com.mbrdi.routing.utilities;

import com.mbrdi.routing.poisearch.dtos.POILocationDetails;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchFilterUtil {

  public static List<POILocationDetails> getNearestPOI(List<POILocationDetails> inputPOIList, Integer range){
    if(inputPOIList==null)
      return inputPOIList;
    else if(inputPOIList.size()==0)
      return inputPOIList;
    else if(range>inputPOIList.size())
      return inputPOIList;
    else if(range==0)
      return new ArrayList<>();
    else{
      Collections.sort(inputPOIList, (POILocationDetails p1, POILocationDetails p2) -> p1.getDistance().compareTo(p2.getDistance()));
      return inputPOIList.subList(0,range);
    }

  }
}
