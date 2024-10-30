package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.resources;

public record CreateNodeResource(
        Long plotId,
        String nodelocation,
        Integer moisture,
        String indicator,
        Boolean isActive

) {
}
