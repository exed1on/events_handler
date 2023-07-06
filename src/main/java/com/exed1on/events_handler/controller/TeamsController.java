package com.exed1on.events_handler.controller;

import com.exed1on.events_handler.service.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.TreeSet;

@RestController
public class TeamsController {
    private final TeamService teamService;

    public TeamsController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams")
    public TreeSet<String> getTeams() {
        return teamService.getTeams();
    }
}
