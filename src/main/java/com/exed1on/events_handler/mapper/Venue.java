package com.exed1on.events_handler.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Venue {
    private String id;
    private String name;
    private int capacity;
    @JsonProperty(value = "city_name")
    private String cityName;
    @JsonProperty(value = "country_name")
    private String countryName;
    @JsonProperty(value = "map_coordinates")
    private String mapCoordinates;
    @JsonProperty(value = "country_code")
    private String countryCode;
}
