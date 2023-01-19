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
@Table(name = "venues")
public class VenueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String venueName;


    public VenueEntity(Event event) {
        if (event.getVenue() == null) this.venueName = "none";
        else this.venueName = event.getVenue().getName();
    }
}

