package com.IoTeam.ThirstySeedAPI.irrigation.domain.services.commands;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.CreatePlotCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.NotSupplyPlotCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.SupplyPlotCommand;


public interface PlotCommandService {
    Long createPlot(CreatePlotCommand command);
    Long updateToPlotSupply(SupplyPlotCommand command);
    Long updateToPlotNotSupply(NotSupplyPlotCommand command);

}
