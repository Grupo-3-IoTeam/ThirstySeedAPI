package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources;

public record UpdateScheduleResource(
        double waterAmount,
        double pressure,
        double sprinklerRadius,
        double expectedMoisture,
        int estimatedTimeHours,
        String setTime,
        int angle,
        boolean isAutomatic
) {
}
