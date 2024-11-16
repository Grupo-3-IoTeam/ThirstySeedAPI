package com.IoTeam.ThirstySeedAPI.irrigation.infrastructure.persistence.jpa.repositories;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Plot;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlotRepository extends JpaRepository<Plot,Long> {
    List<Plot> findByUserId(Long userId);
}
