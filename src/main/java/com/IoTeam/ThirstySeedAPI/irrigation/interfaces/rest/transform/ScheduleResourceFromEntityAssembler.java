package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.transform;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Schedule;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources.ScheduleResource;

public class ScheduleResourceFromEntityAssembler {
    public static ScheduleResource toResourceFromEntity(Schedule entity) {
        return new ScheduleResource(
                entity.getPlot().getId(),
                entity.getWaterAmount().waterAmount(),
                entity.getPressure().pressureValue(),            // Access the pressure field in Pressure
                entity.getSprinklerRadius().radius(),       // Access the radius field in SprinklerRadius
                entity.getExpectedMoisture().level(),       // Access the level field in MoistureLevel
                entity.getEstimatedTime().hours(),          // Access the hours field in IrrigationDuration
                entity.getSetTime().time(),                 // Access the time field in IrrigationTime
                entity.getAngle().angle(),                // Access the degrees field in SprinklerAngle
                entity.getIsAutomatic().isAutomatic()                         // Access the boolean isAutomatic directly
        );
    }
}
