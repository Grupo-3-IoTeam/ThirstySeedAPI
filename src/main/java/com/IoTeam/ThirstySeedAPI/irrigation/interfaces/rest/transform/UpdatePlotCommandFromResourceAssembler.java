package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.transform;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.UpdatePlotCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources.UpdatePlotResource;

public class UpdatePlotCommandFromResourceAssembler {
    public static UpdatePlotCommand toCommand(Long plotId, UpdatePlotResource resource) {
        return new UpdatePlotCommand(
                plotId,
                resource.name(),
                resource.location(),
                resource.extension(),
                resource.size(),
                resource.imageUrl()
        );
    }
}
