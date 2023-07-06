package com.exed1on.events_handler.controller;

import com.exed1on.events_handler.entity.EventEntity;
import com.exed1on.events_handler.repository.EventRepository;
import com.exed1on.events_handler.service.EventsShowService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class EventController {

    private final EventRepository eventRepository;
    private final EventsShowService eventsShowService;

    public EventController(EventRepository eventRepository, EventsShowService eventsShowService) {
        this.eventRepository = eventRepository;
        this.eventsShowService = eventsShowService;
    }

    @GetMapping("/events")
    public List<EventEntity> getAllEvents(@RequestParam(required = false, defaultValue = "10") String matches, HttpServletResponse response) throws IOException {
        int numberMatches = 0;
        try {
            numberMatches = Integer.parseInt(matches);
            if (numberMatches < 1) response.sendRedirect("/events?matches=1");
            else if (numberMatches > eventRepository.count())
                response.sendRedirect("/events?matches=" + eventRepository.count());
        } catch (Exception e) {
            response.sendRedirect("/events?matches=1");
        }

        return eventsShowService.getEvents(numberMatches);
    }
}