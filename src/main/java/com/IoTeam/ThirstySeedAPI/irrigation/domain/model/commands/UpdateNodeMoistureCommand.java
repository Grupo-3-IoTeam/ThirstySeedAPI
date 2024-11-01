package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands;

public record UpdateNodeMoistureCommand(
        Long nodeId,
        Integer moisture
) {
}
