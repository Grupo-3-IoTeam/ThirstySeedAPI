package com.IoTeam.ThirstySeedAPI.irrigation.infrastructure.persistence.jpa.repositories;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Node;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NodeRepository extends JpaRepository<Node,Long> {

    List<Node> findByPlotId(Long idPlot);
}
