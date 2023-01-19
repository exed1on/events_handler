package com.exed1on.events_handler.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class EventResponse {
    @JsonProperty("Events")
    private List<Event> events;
}