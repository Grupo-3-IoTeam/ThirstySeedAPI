package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.transform;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.UpdateScheduleCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources.UpdateScheduleResource;

public class UpdateScheduleCommandFromResourceAssembler {

    public static UpdateScheduleCommand toCommandFromResource(Long scheduleId, UpdateScheduleResource resource) {
        return new UpdateScheduleCommand(
                scheduleId,

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
