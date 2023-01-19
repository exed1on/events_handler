package com.exed1on.events_handler.controller;

import com.exed1on.events_handler.service.EventsShowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

   private final EventsShowService eventsShowService;

    public EventController(EventsShowService eventsShowService) {
        this.eventsShowService = eventsShowService;
    }

    @GetMapping("/events")
    public String getAllEvents(){
        return eventsShowService.getStringEvents(10);
    }
}