package com.exed1on.events_handler.service;

import com.exed1on.events_handler.entity.VenueEntity;
import com.exed1on.events_handler.repository.VenueRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class VenueServiceTest {
    @Mock
    private VenueRepository venueRepository;
    @InjectMocks
    private VenueService venueService;

    @Test
    public void givenEventEntitiesList_whenGetEvents_thenReturnEventEntityList() {
        VenueEntity venue1 = VenueEntity.builder()
                .id(1L)
                .venueName("Stadium One")
                .build();
        VenueEntity venue2 = VenueEntity.builder()
                .id(2L)
                .venueName("Stadium Two")
                .build();
        given(venueRepository.findAll()).willReturn(List.of(venue1, venue2));

        List<VenueEntity> venues = venueService.getVenues(2);

        assertThat(venues).isNotNull();
        assertThat(venues.size()).isEqualTo(2);
    }
}