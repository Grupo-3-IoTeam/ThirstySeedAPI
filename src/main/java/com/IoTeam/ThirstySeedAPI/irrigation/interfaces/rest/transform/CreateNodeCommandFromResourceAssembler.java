package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.transform;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.CreateNodeCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources.CreateNodeResource;

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
