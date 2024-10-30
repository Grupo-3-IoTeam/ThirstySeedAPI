package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.transform;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Plot;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources.PlotResource;

public class PlotResourceFromEntityAssembler {
    public static PlotResource toResourceFromEntity(Plot entity){
        return new PlotResource(
                entity.getId(),
                entity.getName().name(),
                entity.getLocation().location(),
                entity.getExtension().extension(),
                entity.getSize().size(),
                entity.getPlotStatus().name(),
                entity.getImageUrl().imageUrl(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
