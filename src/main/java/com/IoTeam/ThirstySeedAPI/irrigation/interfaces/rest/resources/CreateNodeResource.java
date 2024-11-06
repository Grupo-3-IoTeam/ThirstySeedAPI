package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources;

public record CreateNodeResource(
        Long plotId,
        String nodelocation,
        Integer moisture,
        String indicator,
        Boolean isActive,
        String productcode

) {
}
