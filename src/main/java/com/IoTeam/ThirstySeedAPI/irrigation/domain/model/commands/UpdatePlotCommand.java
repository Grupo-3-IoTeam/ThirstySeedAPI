package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands;

public record UpdatePlotCommand(
        Long plotId,
        String name,
        String location,
        Integer extension,
        Integer size,
        String imageUrl
) { }