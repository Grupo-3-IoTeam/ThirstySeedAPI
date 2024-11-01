package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources;

public record CreatePlotResource(

       String name,
       String location,
       Integer extension,
       Integer size,
       String imageUrl
) {
}
