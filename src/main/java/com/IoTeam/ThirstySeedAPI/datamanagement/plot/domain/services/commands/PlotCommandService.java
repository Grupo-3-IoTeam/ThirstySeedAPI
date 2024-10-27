package com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.services.commands;

import com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.model.commands.CreatePlotCommand;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.model.commands.NotSupplyPlotCommand;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.model.commands.SupplyPlotCommand;


public interface PlotCommandService {
    Long createPlot(CreatePlotCommand command);

    Long updateToPlotSupply(SupplyPlotCommand command);
    Long updateToPlotNotSupply(NotSupplyPlotCommand command);

}
