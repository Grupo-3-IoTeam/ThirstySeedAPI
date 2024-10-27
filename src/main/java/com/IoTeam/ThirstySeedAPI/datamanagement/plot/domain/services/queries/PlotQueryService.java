package com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.services.queries;

import com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.model.aggregates.Plot;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.model.queries.GetPlotByIdQuery;


import java.util.List;
import java.util.Optional;

public interface PlotQueryService {
    Optional<Plot> findPlotById(GetPlotByIdQuery query);
    List<Plot> findAllPlots();
}
