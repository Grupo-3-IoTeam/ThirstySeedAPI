package com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.model.commands;

import java.util.List;

public record CreatePlotCommand(
        String name,
        String location,
        Integer extension,
        Integer size,
        String imageUrl

) {
}
