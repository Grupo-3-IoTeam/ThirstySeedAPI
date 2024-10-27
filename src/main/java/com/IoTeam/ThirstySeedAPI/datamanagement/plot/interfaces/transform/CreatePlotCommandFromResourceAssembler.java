package com.IoTeam.ThirstySeedAPI.datamanagement.plot.interfaces.transform;

import com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.model.commands.CreatePlotCommand;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.interfaces.resources.CreatePlotResource;

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
