package com.exed1on.events_handler.entity;

import com.exed1on.events_handler.mapper.Event;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "competitors")
public class CompetitorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "home_team_name")
    private String homeTeamName;

    @Column(name = "home_team_country")
    private String homeTeamCountry;
    @Column(name = "away_team_name")
    private String awayTeamName;

    @Column(name = "away_team_country")
    private String awayTeamCountry;

    public CompetitorEntity(Event event) {
        this.homeTeamName= String.valueOf(event.getCompetitors().get(0)).substring(String.valueOf(event.getCompetitors().get(0)).indexOf("name=")+5,
                String.valueOf(event.getCompetitors().get(0)).indexOf("country=")-2);
        this.homeTeamCountry= String.valueOf(event.getCompetitors().get(0)).substring(String.valueOf(event.getCompetitors().get(0)).indexOf("country=")+8,
                String.valueOf(event.getCompetitors().get(0)).indexOf("countryCode=")-2);
        this.awayTeamName= String.valueOf(event.getCompetitors().get(1)).substring(String.valueOf(event.getCompetitors().get(1)).indexOf("name=")+5,
                String.valueOf(event.getCompetitors().get(1)).indexOf("country=")-2);
        this.awayTeamCountry= String.valueOf(event.getCompetitors().get(1)).substring(String.valueOf(event.getCompetitors().get(1)).indexOf("country=")+8,
                String.valueOf(event.getCompetitors().get(1)).indexOf("countryCode=")-2);

    }
}

