package com.IoTeam.ThirstySeedAPI.iam.interfaces.rest.transform;

import com.IoTeam.ThirstySeedAPI.iam.domain.model.aggregates.User;
import com.IoTeam.ThirstySeedAPI.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
    }
}
