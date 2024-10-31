package com.IoTeam.ThirstySeedAPI.irrigation.domain.services.commands;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Schedule;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.CreateScheduleCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.DeleteScheduleCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.UpdateScheduleCommand;

import java.util.Optional;

public interface ScheduleCommandService {
    Long handle(CreateScheduleCommand command);
    Optional<Schedule> handle(UpdateScheduleCommand command);
    void handle(DeleteScheduleCommand command);
}