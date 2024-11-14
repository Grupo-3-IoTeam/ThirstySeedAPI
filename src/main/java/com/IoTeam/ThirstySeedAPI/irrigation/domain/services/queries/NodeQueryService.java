package com.IoTeam.ThirstySeedAPI.irrigation.domain.services.queries;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Node;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetNodeByIdQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetNodeByPlotIdQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetNodeByProductCodeQuery;

import java.util.List;
import java.util.Optional;

public interface NodeQueryService {
    Optional<Node> findNodeById(GetNodeByIdQuery query);
    List<Node> findNodeByPlotId(GetNodeByPlotIdQuery query);
    Optional<Node> findNodeByProductcode(GetNodeByProductCodeQuery query);
    List<Node> findAllNodes();
}
