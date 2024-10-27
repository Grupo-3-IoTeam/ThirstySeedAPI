package com.IoTeam.ThirstySeedAPI.datamanagement.plot.infrastructure.persistence.jpa.repositories;

import com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.model.aggregates.Plot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlotRepository extends JpaRepository<Plot,Long> {


}
