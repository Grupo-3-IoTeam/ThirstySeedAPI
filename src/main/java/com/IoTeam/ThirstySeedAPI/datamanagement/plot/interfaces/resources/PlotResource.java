package com.IoTeam.ThirstySeedAPI.datamanagement.plot.interfaces.resources;

import java.util.Date;

public record PlotResource(
        Long id,
        String name,
        String location,
        Integer extension,
        Integer size,
        String status,
        String imageUrl,
        Date createdAt,
        Date updatedAt
) {


}
