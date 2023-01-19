package com.exed1on.events_handler.service;

import com.exed1on.events_handler.entity.VenueEntity;
import com.exed1on.events_handler.mapper.EventResponse;
import com.exed1on.events_handler.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VenueService {
    private final VenueRepository venueRepository;

    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public void saveVenues(EventResponse eventResponse) {
        List<VenueEntity> venueEntities = eventResponse.getEvents().stream()
                .map(VenueEntity::new)
                .collect(Collectors.toList());
        venueRepository.saveAll(venueEntities);
    }
}
