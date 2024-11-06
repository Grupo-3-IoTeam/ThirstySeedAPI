package com.IoTeam.ThirstySeedAPI.irrigation.application.internal.queryservices;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Node;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetNodeByIdQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetNodeByPlotIdQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetNodeByProductCodeQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects.Productcode;
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
    public List<Node> findNodeByPlotId(GetNodeByPlotIdQuery query) {
        return nodeRepository.findByPlotId(query.idPlot());
    }
    @Override
    public Optional<Node> findNodeByProductcode(GetNodeByProductCodeQuery query) {
        return nodeRepository.findByProductcode(new Productcode(query.productcode()));
    }

    @Override
    public List<Node> findAllNodes() {
        return nodeRepository.findAll();
    }
}
