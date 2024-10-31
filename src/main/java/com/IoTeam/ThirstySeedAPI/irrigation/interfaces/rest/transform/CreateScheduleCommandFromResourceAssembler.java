package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.transform;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.CreateScheduleCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources.CreateScheduleResource;

public class CreateScheduleCommandFromResourceAssembler {
    public static CreateScheduleCommand toCommandFromResource(CreateScheduleResource resource) {
        return new CreateScheduleCommand(
                resource.plotId(),
                resource.waterAmount(),
                resource.pressure(),
                resource.sprinklerRadius(),
                resource.expectedMoisture(),
                resource.estimatedTimeHours(),
                resource.setTime(),
                resource.angle(),
                resource.isAutomatic()
        );
    }
}
