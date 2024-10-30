package com.IoTeam.ThirstySeedAPI.irrigation.domain.services.commands;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.CreateScheduleCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.DeleteScheduleCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.UpdateScheduleCommand;

public interface ScheduleCommandService {
    Long createSchedule(CreateScheduleCommand command);
    Long updateSchedule(UpdateScheduleCommand command);
    void deleteSchedule(DeleteScheduleCommand command);
}

