package com.IoTeam.ThirstySeedAPI.profile.interfaces.rest.transform;

import com.IoTeam.ThirstySeedAPI.profile.domain.model.commands.CreateProfileCommand;
import com.IoTeam.ThirstySeedAPI.profile.interfaces.rest.resources.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource) {
        return new CreateProfileCommand(resource.userId(), resource.firstName(), resource.lastName(), resource.email(), resource.phoneNumber(), resource.profileImage(), resource.location());
    }
}
