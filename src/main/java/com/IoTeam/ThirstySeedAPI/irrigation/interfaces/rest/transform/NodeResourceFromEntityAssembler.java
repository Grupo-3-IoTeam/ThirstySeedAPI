package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.transform;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Node;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources.NodeResource;

public class NodeResourceFromEntityAssembler {
    public static NodeResource toResourceFromEntity(Node entity){
        return new NodeResource(
                entity.getId(),
                entity.getPlot().getId(),
                entity.getNodelocation().nodelocation(),
                entity.getMoisture().moisture(),
                entity.getIndicator().indicator(),
                entity.getStatus().status(),
                entity.getStatusClass().statusClass(),
                entity.getIconClass().iconClass(),
                entity.getIsActive().value(),
                entity.getProductcode().productcode()
        );
    }
}
