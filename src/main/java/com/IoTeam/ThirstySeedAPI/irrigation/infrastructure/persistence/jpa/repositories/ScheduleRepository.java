package com.IoTeam.ThirstySeedAPI.irrigation.infrastructure.persistence.jpa.repositories;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
