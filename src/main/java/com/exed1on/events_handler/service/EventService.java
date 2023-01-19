package com.exed1on.events_handler.service;

import com.exed1on.events_handler.entity.EventEntity;
import com.exed1on.events_handler.mapper.EventResponse;
import com.exed1on.events_handler.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void saveEvents(EventResponse eventResponse) {
        List<EventEntity> eventEntities = eventResponse.getEvents().stream()
                .map(EventEntity::new)
                .collect(Collectors.toList());
        eventRepository.saveAll(eventEntities);
    }

    public List<EventEntity> getEvents(int amount) {
        List<EventEntity> resultList = new ArrayList<>();
        List<EventEntity> allEvents = eventRepository.findAll();
        for (int i = 0; i < amount; i++) {
            if (i == (long) allEvents.size()) break;
            resultList.add(allEvents.get(i));
        }
        System.out.println(resultList);
        return resultList;
    }
}

