package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands;

public record CreateNodeCommand(
        Long plotId,
        String nodelocation,
        Integer moisture,
        String indicator,
        Boolean  isActive,
        String productCode

) {
}
