package com.IoTeam.ThirstySeedAPI.irrigation.application.internal.queryservices;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Plot;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetPlotByIdQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.services.queries.PlotQueryService;
import com.IoTeam.ThirstySeedAPI.irrigation.infrastructure.persistence.jpa.repositories.PlotRepository;

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

    @Override
    public List<Plot> findPlotsByUserId(Long userId) {
        return plotRepository.findByUserId(userId);
    }
}
