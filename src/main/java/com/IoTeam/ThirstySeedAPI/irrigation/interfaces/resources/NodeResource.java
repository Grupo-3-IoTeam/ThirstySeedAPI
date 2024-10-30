package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.resources;

public record NodeResource(
        Long id,
        Long plotId,
        String nodelocation,   // Match NodeLocation field type
        Integer moisture,      // Match Moisture field type
        String indicator,      // Match Indicator field type
        String status,         // Include Status field if needed
        String statusClass,    // Include StatusClass field if needed
        String iconClass,      // Include IconClass field if needed
        Boolean isActive

) {


}
