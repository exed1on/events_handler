package com.exed1on.events_handler.service;

import com.exed1on.events_handler.entity.CompetitorEntity;
import com.exed1on.events_handler.repository.CompetitorRepository;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeSet;

@EqualsAndHashCode
@Service
public class TeamService {
    private final CompetitorRepository competitorRepository;

    public TeamService(CompetitorRepository competitorRepository) {
        this.competitorRepository = competitorRepository;
    }

    public TreeSet<String> getUniqueSortedTeams() {
        TreeSet<String> resultSet = new TreeSet<>();
        List<CompetitorEntity> allTeams = competitorRepository.findAll();
        for (int i = 0; i < allTeams.size(); i++) {
            resultSet.add(allTeams.get(i).getHomeTeamName());
            resultSet.add(allTeams.get(i).getAwayTeamName());
        }
        return resultSet;
    }

    public String getStringTeams() {
        String teams = "";
        for (String team : getUniqueSortedTeams()) {
            teams += team;
            if (!team.equals(getUniqueSortedTeams().pollLast())) teams += "\n";
        }
        return teams;
    }
}
