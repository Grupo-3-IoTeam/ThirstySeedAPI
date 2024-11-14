package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources;

import java.util.Date;

public record PlotResource(
        Long id,
        Long userId,
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
