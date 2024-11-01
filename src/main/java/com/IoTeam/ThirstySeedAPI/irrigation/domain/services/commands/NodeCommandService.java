package com.IoTeam.ThirstySeedAPI.irrigation.domain.services.commands;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.CreateNodeCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.UpdateNodeMoistureCommand;


public interface NodeCommandService {
    Long createNode(CreateNodeCommand command);
    void updateNodeMoisture(UpdateNodeMoistureCommand command);

}
