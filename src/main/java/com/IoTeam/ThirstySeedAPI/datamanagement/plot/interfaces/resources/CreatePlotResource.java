package com.IoTeam.ThirstySeedAPI.datamanagement.plot.interfaces.resources;

public record CreatePlotResource(

       String name,
       String location,
       Integer extension,
       Integer size,
       String imageUrl
) {
}
