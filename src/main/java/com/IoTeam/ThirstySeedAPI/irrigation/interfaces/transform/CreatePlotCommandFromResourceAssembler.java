package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.transform;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.CreatePlotCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.resources.CreatePlotResource;

public class CreatePlotCommandFromResourceAssembler {
    public static CreatePlotCommand toCommandFromResource(CreatePlotResource resource){
        return new CreatePlotCommand(
                resource.name(),
                resource.location(),
                resource.extension(),
                resource.size(),
                resource.imageUrl()
        );
    }
}
