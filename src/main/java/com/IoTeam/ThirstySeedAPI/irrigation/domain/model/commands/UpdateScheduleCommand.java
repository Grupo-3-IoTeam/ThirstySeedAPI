package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands;

public record UpdateScheduleCommand(
        Long scheduleId,
        double waterAmount,
        double pressure,
        double sprinklerRadius,
        double expectedMoisture,
        int estimatedTimeHours,
        String setTime,
        int angle,
        boolean isAutomatic
) { }