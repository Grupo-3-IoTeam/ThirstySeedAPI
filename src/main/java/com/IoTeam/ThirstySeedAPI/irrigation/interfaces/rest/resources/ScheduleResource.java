package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources;

public record ScheduleResource(
        Long plotId,
        double waterAmount,
        double pressure,
        double sprinklerRadius,
        double expectedMoisture,
        int estimatedTimeHours,
        String setTime,
        int angle,
        boolean isAutomatic
) { }