package com.IoTeam.ThirstySeedAPI.irrigation.domain.services.commands;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.CreateNodeCommand;


public interface NodeCommandService {
    Long createNode(CreateNodeCommand command);


}
