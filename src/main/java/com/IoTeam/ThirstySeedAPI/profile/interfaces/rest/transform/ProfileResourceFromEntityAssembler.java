package com.IoTeam.ThirstySeedAPI.profile.interfaces.rest.transform;

import com.IoTeam.ThirstySeedAPI.profile.domain.model.aggregates.Profile;
import com.IoTeam.ThirstySeedAPI.profile.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile entity) {
        return new ProfileResource(entity.getId(), entity.getUserId(), entity.getFullName(), entity.getEmailAddress(), entity.getPhoneNumber(), entity.getProfileImage(), entity.getLocation());
    }
}
