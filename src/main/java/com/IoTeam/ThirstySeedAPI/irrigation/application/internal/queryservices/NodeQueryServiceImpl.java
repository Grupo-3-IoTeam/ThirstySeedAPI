package com.IoTeam.ThirstySeedAPI.irrigation.application.internal.queryservices;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Node;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetNodeByIdQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetNodeByPlotIdQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.services.queries.NodeQueryService;
import com.IoTeam.ThirstySeedAPI.irrigation.infrastructure.persistence.jpa.repositories.NodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NodeQueryServiceImpl implements NodeQueryService {

    private final NodeRepository nodeRepository;

    public NodeQueryServiceImpl(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    @Override
    public Optional<Node> findNodeById(GetNodeByIdQuery query) {
        return nodeRepository.findById(query.idNode());
    }

    @Override
    public Optional<Node> findNodeByPlotId(GetNodeByPlotIdQuery query) {
        return nodeRepository.findByPlotId(query.idPlot())
                .stream()
                .findFirst();
    }

    @Override
    public List<Node> findAllNodes() {
        return nodeRepository.findAll();
    }
}
