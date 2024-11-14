package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources;

public record UpdatePlotResource(
        String name,
        String location,
        Integer extension,
        Integer size,
        String imageUrl
) {
}
