package com.IoTeam.ThirstySeedAPI.irrigation.infrastructure.persistence.jpa.repositories;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByPlotId(Long userId);

    List<Schedule> findByPlotIdIn(List<Long> plotIds);
}