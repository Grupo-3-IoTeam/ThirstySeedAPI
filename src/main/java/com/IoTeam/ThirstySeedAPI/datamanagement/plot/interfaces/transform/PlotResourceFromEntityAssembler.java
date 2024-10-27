package com.IoTeam.ThirstySeedAPI.datamanagement.plot.interfaces.transform;

import com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.model.aggregates.Plot;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.interfaces.resources.PlotResource;

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
