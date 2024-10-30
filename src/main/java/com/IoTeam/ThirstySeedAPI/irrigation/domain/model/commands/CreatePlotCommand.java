package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands;

public record CreatePlotCommand(
        String name,
        String location,
        Integer extension,
        Integer size,
        String imageUrl

) {
}
