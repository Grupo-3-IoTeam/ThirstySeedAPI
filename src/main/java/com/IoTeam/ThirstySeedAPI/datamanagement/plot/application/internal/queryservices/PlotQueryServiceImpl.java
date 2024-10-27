package com.IoTeam.ThirstySeedAPI.datamanagement.plot.application.internal.queryservices;

import com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.model.aggregates.Plot;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.model.queries.GetPlotByIdQuery;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.services.queries.PlotQueryService;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.infrastructure.persistence.jpa.repositories.PlotRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlotQueryServiceImpl implements PlotQueryService {

    private final PlotRepository plotRepository;

    public PlotQueryServiceImpl(PlotRepository plotRepository) {
        this.plotRepository = plotRepository;
    }

    @Override
    public Optional<Plot> findPlotById(GetPlotByIdQuery query) {
        return plotRepository.findById(query.idPlot());
    }
    @Override
    public List<Plot> findAllPlots(){
        return plotRepository.findAll();
    }
}
