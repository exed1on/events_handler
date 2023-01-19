package com.exed1on.events_handler.entity;


import com.exed1on.events_handler.mapper.Event;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "events")
@Builder
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_date")
    private String startDate;
    @Column(name = "probable_result_name")
    private ProbableResultName probableResultName;
    @Column(name = "probable_result_chance")
    private double probableResultChance;

    public EventEntity(Event event) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.startDate = LocalDateTime.parse(event.getStartDate().substring(0,event.getStartDate().indexOf("+"))).format(formatter);
        if(event.getProbabilityHomeTeamWinner()>event.getProbabilityDraw()&&event.getProbabilityHomeTeamWinner()>event.getProbabilityAwayTeamWinner()) {
            this.probableResultName = ProbableResultName.HOME_TEAM_WIN;
            probableResultChance=event.getProbabilityHomeTeamWinner();
        }
        if(event.getProbabilityAwayTeamWinner()>event.getProbabilityDraw()&&event.getProbabilityAwayTeamWinner()>event.getProbabilityHomeTeamWinner())
        {
            this.probableResultName=ProbableResultName.AWAY_TEAM_WIN;
            probableResultChance=event.getProbabilityAwayTeamWinner();}
        if(event.getProbabilityDraw()>event.getProbabilityHomeTeamWinner()&&event.getProbabilityDraw()>event.getProbabilityAwayTeamWinner()) {
            this.probableResultName = ProbableResultName.DRAW;
            probableResultChance=event.getProbabilityDraw();
        }
    }
}
