package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.transform;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.UpdateNodeCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.UpdateNodeMoistureCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources.UpdateNodeMoistureResource;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources.UpdateNodeResource;

public class UpdateNodeCommandFromResourceAssembler {
    public static UpdateNodeCommand toCommand(Long nodeId, UpdateNodeResource resource) {
        return new UpdateNodeCommand(nodeId, resource.nodelocation());
    }
}
