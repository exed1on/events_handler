package com.exed1on.events_handler.controller;

import com.exed1on.events_handler.repository.EventRepository;
import com.exed1on.events_handler.service.EventsShowService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class EventController {

    private final EventRepository eventRepository;
    private final EventsShowService eventsShowService;

    public EventController(EventRepository eventRepository, EventsShowService eventsShowService) {
        this.eventRepository = eventRepository;
        this.eventsShowService = eventsShowService;
    }

    private String result = "";

    @GetMapping("/events")
    public String getAllEvents(@RequestParam(required = false, defaultValue = "10") String matches, HttpServletResponse response) throws IOException {
        int numberMatches;
        try {
            numberMatches = Integer.parseInt(matches);
            if (numberMatches < 1) response.sendRedirect("/events?matches=1");
            else if (numberMatches > eventRepository.count())
                response.sendRedirect("/events?matches=" + eventRepository.count());
            else {
                result = eventsShowService.getStringEvents(numberMatches);
            }
        } catch (Exception e) {
            response.sendRedirect("/events?matches=1");
        }

        return result;
    }
}