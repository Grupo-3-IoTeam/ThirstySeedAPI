package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.transform;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.CreateNodeCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.UpdateNodeMoistureCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources.CreateNodeResource;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources.UpdateNodeMoistureResource;

public class UpdateNodeMoistureCommandFromResourceAssembler {
    public static UpdateNodeMoistureCommand toCommand(Long nodeId, UpdateNodeMoistureResource resource) {
        return new UpdateNodeMoistureCommand(nodeId, resource.moisture());
    }
}
