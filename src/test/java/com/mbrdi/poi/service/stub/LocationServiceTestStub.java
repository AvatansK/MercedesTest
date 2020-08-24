package com.mbrdi.poi.service.stub;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mbrdi.poi.dtos.LocationPOIResponse;

public class LocationServiceTestStub {

  private static ObjectMapper objectMapper = new ObjectMapper();
  public static LocationPOIResponse getValidLocationPOIResponse() throws Exception{
    return objectMapper.readValue(validLocationPOIResponse,LocationPOIResponse.class);
  }

  public static String validLocationPOIResponse = "{\n"
      + "  \"restaurantPOI\": [\n"
      + "    {\n"
      + "      \"position\": {\n"
      + "        \"lat\": \"52.51602\",\n"
      + "        \"lng\": \"13.37694\"\n"
      + "      },\n"
      + "      \"title\": \"Die Ess-Bahn\",\n"
      + "      \"distance\": 53,\n"
      + "      \"openingHours\": [\n"
      + "        {\n"
      + "          \"text\": [\n"
      + "            \"Mon-Sun: 08:00 - 24:00\"\n"
      + "          ],\n"
      + "          \"isOpen\": true\n"
      + "        }\n"
      + "      ]\n"
      + "    },\n"
      + "    {\n"
      + "      \"position\": {\n"
      + "        \"lat\": \"52.51603\",\n"
      + "        \"lng\": \"13.37694\"\n"
      + "      },\n"
      + "      \"title\": \"Aadava\",\n"
      + "      \"distance\": 53,\n"
      + "      \"openingHours\": null\n"
      + "    },\n"
      + "    {\n"
      + "      \"position\": {\n"
      + "        \"lat\": \"52.51657\",\n"
      + "        \"lng\": \"13.37835\"\n"
      + "      },\n"
      + "      \"title\": \"SUBWAY\",\n"
      + "      \"distance\": 87,\n"
      + "      \"openingHours\": null\n"
      + "    }\n"
      + "  ],\n"
      + "  \"chargingStationPOI\": [\n"
      + "    {\n"
      + "      \"position\": {\n"
      + "        \"lat\": \"52.51612\",\n"
      + "        \"lng\": \"13.38003\"\n"
      + "      },\n"
      + "      \"title\": \"Electric Vehicle Charging Station\",\n"
      + "      \"distance\": 160,\n"
      + "      \"openingHours\": null\n"
      + "    },\n"
      + "    {\n"
      + "      \"position\": {\n"
      + "        \"lat\": \"52.51612\",\n"
      + "        \"lng\": \"13.38003\"\n"
      + "      },\n"
      + "      \"title\": \"Unter den Linden 77\",\n"
      + "      \"distance\": 160,\n"
      + "      \"openingHours\": [\n"
      + "        {\n"
      + "          \"text\": [\n"
      + "            \"Mon-Sun: 00:00 - 23:59\"\n"
      + "          ],\n"
      + "          \"isOpen\": true\n"
      + "        }\n"
      + "      ]\n"
      + "    },\n"
      + "    {\n"
      + "      \"position\": {\n"
      + "        \"lat\": \"52.51602\",\n"
      + "        \"lng\": \"13.38024\"\n"
      + "      },\n"
      + "      \"title\": \"Apcoa Parking Deutschland\",\n"
      + "      \"distance\": 172,\n"
      + "      \"openingHours\": null\n"
      + "    }\n"
      + "  ],\n"
      + "  \"parkingSpotPOI\": [\n"
      + "    {\n"
      + "      \"position\": {\n"
      + "        \"lat\": \"52.52018\",\n"
      + "        \"lng\": \"13.40414\"\n"
      + "      },\n"
      + "      \"title\": \"City Quartier Dom Aquarée\",\n"
      + "      \"distance\": 1851,\n"
      + "      \"openingHours\": [\n"
      + "        {\n"
      + "          \"text\": [\n"
      + "            \"Mon-Sun: 00:00 - 24:00\"\n"
      + "          ],\n"
      + "          \"isOpen\": true\n"
      + "        }\n"
      + "      ]\n"
      + "    },\n"
      + "    {\n"
      + "      \"position\": {\n"
      + "        \"lat\": \"53.94851\",\n"
      + "        \"lng\": \"10.02978\"\n"
      + "      },\n"
      + "      \"title\": \"Wildpark Eekholt\",\n"
      + "      \"distance\": 273870,\n"
      + "      \"openingHours\": [\n"
      + "        {\n"
      + "          \"text\": [\n"
      + "            \"Mon-Sun: 09:00 - 16:00\"\n"
      + "          ],\n"
      + "          \"isOpen\": true\n"
      + "        }\n"
      + "      ]\n"
      + "    },\n"
      + "    {\n"
      + "      \"position\": {\n"
      + "        \"lat\": \"40.70079\",\n"
      + "        \"lng\": \"-74.18685\"\n"
      + "      },\n"
      + "      \"title\": \"Parking Spot - Haynes\",\n"
      + "      \"distance\": 6395471,\n"
      + "      \"openingHours\": [\n"
      + "        {\n"
      + "          \"text\": [\n"
      + "            \"Mon-Sun: 00:00 - 24:00\"\n"
      + "          ],\n"
      + "          \"isOpen\": true\n"
      + "        }\n"
      + "      ]\n"
      + "    }\n"
      + "  ]\n"
      + "}";
}