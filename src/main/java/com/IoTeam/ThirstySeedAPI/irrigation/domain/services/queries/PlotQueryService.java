package com.IoTeam.ThirstySeedAPI.irrigation.domain.services.queries;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Plot;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetPlotByIdQuery;


import java.util.List;
import java.util.Optional;

public interface PlotQueryService {
    Optional<Plot> findPlotById(GetPlotByIdQuery query);
    List<Plot> findAllPlots();
    List<Plot> findPlotsByUserId(Long userId);
}
