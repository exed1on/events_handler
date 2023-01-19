package com.exed1on.events_handler.configuration;

import com.exed1on.events_handler.mapper.EventResponse;
import com.exed1on.events_handler.reader.JsonFileReader;
import com.exed1on.events_handler.service.CompetitorService;
import com.exed1on.events_handler.service.EventService;
import com.exed1on.events_handler.service.EventsShowService;
import com.exed1on.events_handler.service.VenueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EventService eventService,
                                   CompetitorService competitorService,
                                   VenueService venueService) {
        EventResponse eventResponse = JsonFileReader.readJsonFromFile();
        return args -> {
            log.info("Loading events...");
            eventService.saveEvents(eventResponse);
            log.info("Loading competitors...");
            competitorService.saveCompetitors(eventResponse);
            log.info("Loading venues...");
            venueService.saveVenues(eventResponse);

        };


    }
}
