package com.IoTeam.ThirstySeedAPI.irrigation.domain.services.commands;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.*;


public interface PlotCommandService {
    Long createPlot(CreatePlotCommand command);
    Long updateToPlotSupply(SupplyPlotCommand command);
    Long updateToPlotNotSupply(NotSupplyPlotCommand command);
    void updatePlot(UpdatePlotCommand command);
    void deletePlot(DeletePlotCommand command);
}
