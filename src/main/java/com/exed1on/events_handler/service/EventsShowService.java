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

    public String getStringEvents(int numberMatches) {
        String result = "";
        List<EventEntity> event = eventService.getEvents(numberMatches);
        List<CompetitorEntity> competitor = competitorService.getCompetitors(numberMatches);
        List<VenueEntity> venue = venueService.getVenues(numberMatches);

        for (int i = 0; i < (long) eventService.getEvents(numberMatches).size(); i++) {
            if (i > 0) result += "\n";
            result += "Start date: " + event.get(i).getStartDate() + "\n";
            result += competitor.get(i).getHomeTeamName() + "(" + competitor.get(i).getHomeTeamCountry() + ")"
                    + " vs " + competitor.get(i).getAwayTeamName() + "(" + competitor.get(i).getAwayTeamCountry() + ")" + "\n";
            result += "Venue: " + venue.get(i).getVenueName() + "\n";
            result += "Highest probable result: " + event.get(i).getProbableResultName() +
                    "(" + event.get(i).getProbableResultChance() + ")";
        }
        return result;
    }
}
