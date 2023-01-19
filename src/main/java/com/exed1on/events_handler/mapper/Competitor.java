package com.exed1on.events_handler.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Competitor {
    private String id;
    private String name;
    private String country;
    @JsonProperty(value = "country_code")
    private String countryCode;
    private String abbreviation;
    private String qualifier;
    private String gender;
}
