package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.resources;

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
