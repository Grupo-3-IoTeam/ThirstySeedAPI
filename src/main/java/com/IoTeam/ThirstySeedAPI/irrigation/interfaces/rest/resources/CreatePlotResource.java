package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources;

public record CreatePlotResource(
       Long userId,
       String name,
       String location,
       Integer extension,
       Integer size,
       String imageUrl
) {
}
