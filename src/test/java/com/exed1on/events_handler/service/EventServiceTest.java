package com.exed1on.events_handler.service;

import com.exed1on.events_handler.entity.EventEntity;
import com.exed1on.events_handler.entity.ProbableResultName;
import com.exed1on.events_handler.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {
    @Mock
    private EventRepository eventRepository;
    @InjectMocks
    private EventService eventService;

    @Test
    public void givenEventEntitiesList_whenGetEvents_thenReturnEventEntityList() {
        EventEntity event1 = EventEntity.builder()
                .id(1L)
                .startDate("2023-01-20 13:00:00")
                .probableResultChance(75.0)
                .probableResultName(ProbableResultName.AWAY_TEAM_WIN)
                .build();
        EventEntity event2 = EventEntity.builder()
                .id(2L)
                .startDate("2023-01-20 12:00:00")
                .probableResultChance(50.0)
                .probableResultName(ProbableResultName.HOME_TEAM_WIN)
                .build();
        given(eventRepository.findAll()).willReturn(List.of(event1, event2));

        List<EventEntity> events = eventService.getEvents(2);

        assertThat(events).isNotNull();
        assertThat(events.size()).isEqualTo(2);
    }
}