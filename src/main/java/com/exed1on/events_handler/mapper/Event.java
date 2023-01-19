package com.exed1on.events_handler.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Event {
    @JsonProperty(value = "sport_event_id")
    private String sportEventId;
    @JsonProperty(value = "start_date")
    private String startDate;
    @JsonProperty(value = "sport_name")
    private String sportName;
    @JsonProperty(value = "competition_name")
    private String competitionName;
    @JsonProperty(value = "competition_id")
    private String competitionId;
    @JsonProperty(value = "season_name")
    private String seasonName;
    private List<Competitor> competitors;
    private Venue venue;
    @JsonProperty(value = "probability_home_team_winner")
    private double probabilityHomeTeamWinner;
    @JsonProperty(value = "probability_draw")
    private double probabilityDraw;
    @JsonProperty(value = "probability_away_team_winner")
    private double probabilityAwayTeamWinner;
}

