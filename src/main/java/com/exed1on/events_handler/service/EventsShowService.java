package com.exed1on.events_handler.service;

import com.exed1on.events_handler.entity.CompetitorEntity;
import com.exed1on.events_handler.entity.EventEntity;
import com.exed1on.events_handler.entity.VenueEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsShowService {
    private final EventService eventService;
    private final CompetitorService competitorService;
    private final VenueService venueService;

    public EventsShowService(EventService eventService, CompetitorService competitorService, VenueService venueService) {
        this.eventService = eventService;
        this.competitorService = competitorService;
        this.venueService = venueService;
    }

    public List<EventEntity> getEvents(int numberMatches) {
        return eventService.getEvents(numberMatches);
    }
}
