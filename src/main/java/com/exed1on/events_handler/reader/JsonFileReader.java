package com.exed1on.events_handler.reader;

import com.exed1on.events_handler.mapper.EventResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class JsonFileReader {

    public static EventResponse readJsonFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        EventResponse eventResponse = null;
        try {
            File jsonFile = new File(Objects.requireNonNull(JsonFileReader.class.getResource("/json/data.json")).getFile());
            eventResponse = objectMapper.readValue(jsonFile, EventResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return eventResponse;
    }
}
