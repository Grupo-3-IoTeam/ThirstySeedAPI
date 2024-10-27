package com.IoTeam.ThirstySeedAPI.datamanagement.plot.application.internal.commandservices;

import com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.model.aggregates.Plot;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.model.commands.CreatePlotCommand;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.model.commands.NotSupplyPlotCommand;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.model.commands.SupplyPlotCommand;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.model.valueobjects.*;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.services.commands.PlotCommandService;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.infrastructure.persistence.jpa.repositories.PlotRepository;
import org.springframework.stereotype.Service;

@Service
public class PlotCommandServiceImpl implements PlotCommandService {

    private final PlotRepository plotRepository;

    public PlotCommandServiceImpl(PlotRepository plotRepository) {
        this.plotRepository = plotRepository;
    }

    @Override
    public Long createPlot(CreatePlotCommand command) {
        Plot plot = new Plot(
                new Name(command.name()),
                new Location(command.location()),
                new Extension(command.extension()),
                new Size(command.size()),
                PlotStatus.REQUESTED,
                new ImageUrl(command.imageUrl())
        );
        plotRepository.save(plot);
        return plot.getId();
    }

    @Override
    public Long updateToPlotSupply(SupplyPlotCommand command) {
        return plotRepository.findById(command.plotId())
                .map(plot -> {
                    plot.supply();
                    plotRepository.save(plot);
                    return plot.getId();
                }).orElseThrow(() -> new RuntimeException("Plot not found"));
    }

    @Override
    public Long updateToPlotNotSupply(NotSupplyPlotCommand command) {
        return plotRepository.findById(command.plotId())
                .map(plot -> {
                    plot.not_supply();
                    plotRepository.save(plot);
                    return plot.getId();
                }).orElseThrow(() -> new RuntimeException("Plot not found"));
    }
}
