package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources;

public record NodeResource(
        Long id,
        Long plotId,
        String nodelocation,
        Integer moisture,
        String indicator,
        String status,
        String statusClass,
        String iconClass,
        Boolean isActive,
        String productcode

) {


}
