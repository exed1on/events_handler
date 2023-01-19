package com.exed1on.events_handler.service;

import com.exed1on.events_handler.entity.CompetitorEntity;
import com.exed1on.events_handler.mapper.EventResponse;
import com.exed1on.events_handler.repository.CompetitorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetitorService {
    private final CompetitorRepository competitorRepository;

    public CompetitorService(CompetitorRepository competitorRepository) {
        this.competitorRepository = competitorRepository;
    }

    public void saveCompetitors(EventResponse eventResponse) {
        List<CompetitorEntity> competitorEntities = eventResponse.getEvents().stream()
                .map(CompetitorEntity::new)
                .collect(Collectors.toList());
        competitorRepository.saveAll(competitorEntities);
    }
}
