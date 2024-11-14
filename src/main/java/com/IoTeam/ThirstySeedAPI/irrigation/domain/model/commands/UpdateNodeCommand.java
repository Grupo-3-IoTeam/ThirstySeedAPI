package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands;

public record UpdateNodeCommand(
        Long nodeId,
        String nodelocation
) { }