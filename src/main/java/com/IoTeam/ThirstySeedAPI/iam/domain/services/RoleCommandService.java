package com.IoTeam.ThirstySeedAPI.iam.domain.services;

import com.IoTeam.ThirstySeedAPI.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
