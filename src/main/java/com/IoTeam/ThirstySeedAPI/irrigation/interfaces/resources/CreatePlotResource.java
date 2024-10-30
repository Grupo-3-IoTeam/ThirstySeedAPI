package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.resources;

public record CreatePlotResource(

       String name,
       String location,
       Integer extension,
       Integer size,
       String imageUrl
) {
}
