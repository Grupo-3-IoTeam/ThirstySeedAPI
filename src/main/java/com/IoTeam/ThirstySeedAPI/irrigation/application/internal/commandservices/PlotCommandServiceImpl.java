package com.IoTeam.ThirstySeedAPI.irrigation.application.internal.commandservices;

import com.IoTeam.ThirstySeedAPI.iam.domain.model.aggregates.User;
import com.IoTeam.ThirstySeedAPI.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Plot;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.CreatePlotCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.NotSupplyPlotCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.SupplyPlotCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects.*;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.services.commands.PlotCommandService;
import com.IoTeam.ThirstySeedAPI.irrigation.infrastructure.persistence.jpa.repositories.PlotRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlotCommandServiceImpl implements PlotCommandService {

    private final PlotRepository plotRepository;
    private final UserRepository userRepository;

    public PlotCommandServiceImpl(PlotRepository plotRepository, UserRepository userRepository) {
        this.plotRepository = plotRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Long createPlot(CreatePlotCommand command) {
        // Verificar si el UserID existe antes de crear la Subscription
        Optional<User> optionalUser = userRepository.findById(command.userId());
        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("User with ID " + command.userId() + " does not exist.");
        }
        User user = optionalUser.get();

        Plot plot = new Plot(
                user,
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
