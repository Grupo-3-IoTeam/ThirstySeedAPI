package com.IoTeam.ThirstySeedAPI.profile.domain.services;

import com.IoTeam.ThirstySeedAPI.profile.domain.model.aggregates.Profile;
import com.IoTeam.ThirstySeedAPI.profile.domain.model.commands.CreateProfileCommand;

import java.util.Optional;

public interface ProfileCommandService {
    Optional<Profile> handle(CreateProfileCommand command);
}
