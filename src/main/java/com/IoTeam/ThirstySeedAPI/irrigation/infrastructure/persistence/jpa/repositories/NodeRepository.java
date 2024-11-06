package com.IoTeam.ThirstySeedAPI.irrigation.infrastructure.persistence.jpa.repositories;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Node;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects.Productcode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NodeRepository extends JpaRepository<Node,Long> {

    List<Node> findByPlotId(Long idPlot);
    Optional<Node> findByProductcode(Productcode productcode);

}
