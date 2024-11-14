package com.IoTeam.ThirstySeedAPI.iam.interfaces.rest.transform;

import com.IoTeam.ThirstySeedAPI.iam.domain.model.entities.Role;
import com.IoTeam.ThirstySeedAPI.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role role) {
        return new RoleResource(role.getId(), role.getStringName());
    }
}
