package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.transform;

import com.IoTeam.ThirstySeedAPI.datamanagement.node.domain.model.aggregates.Node;
import com.IoTeam.ThirstySeedAPI.datamanagement.node.interfaces.resources.NodeResource;

public class NodeResourceFromEntityAssembler {
    public static NodeResource toResourceFromEntity(Node entity){
        return new NodeResource(
                entity.getId(),
                entity.getPlot().getId(),
                entity.getNodelocation().nodelocation(),  // Access NodeLocation field
                entity.getMoisture().moisture(),          // Access Moisture field
                entity.getIndicator().indicator(),        // Access Indicator field
                entity.getStatus().status(),              // Access Status field if included
                entity.getStatusClass().statusClass(),    // Access StatusClass field if included
                entity.getIconClass().iconClass(),        // Access IconClass field if included
                entity.getIsActive().value()

        );
    }
}
