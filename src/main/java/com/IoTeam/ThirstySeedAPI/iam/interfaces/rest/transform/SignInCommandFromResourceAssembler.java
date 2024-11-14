package com.IoTeam.ThirstySeedAPI.iam.interfaces.rest.transform;

import com.IoTeam.ThirstySeedAPI.iam.domain.model.commands.SignInCommand;
import com.IoTeam.ThirstySeedAPI.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password());
    }
}
