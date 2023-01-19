package com.exed1on.events_handler.repository;

import com.exed1on.events_handler.entity.CompetitorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitorRepository extends JpaRepository<CompetitorEntity, Long> {
}
