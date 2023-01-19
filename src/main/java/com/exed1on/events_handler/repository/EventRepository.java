package com.exed1on.events_handler.repository;

import com.exed1on.events_handler.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
