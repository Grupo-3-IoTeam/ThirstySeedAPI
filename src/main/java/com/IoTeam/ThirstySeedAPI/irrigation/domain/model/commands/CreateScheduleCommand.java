package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands;

public record CreateScheduleCommand(
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