package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.transform;

import com.IoTeam.ThirstySeedAPI.datamanagement.node.domain.model.commands.CreateNodeCommand;
import com.IoTeam.ThirstySeedAPI.datamanagement.node.interfaces.resources.CreateNodeResource;

public class CreateNodeCommandFromResourceAssembler {
    public static CreateNodeCommand toCommandFromResource(CreateNodeResource resource){
        return new CreateNodeCommand(
                resource.plotId(),
                resource.nodelocation(),  // Pass NodeLocation as String
                resource.moisture(),      // Pass Moisture as Integer
                resource.indicator(),     // Pass Indicator as String
                resource.isActive()
        );
    }
}
