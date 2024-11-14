package com.IoTeam.ThirstySeedAPI.profile.domain.services;

import com.IoTeam.ThirstySeedAPI.profile.domain.model.aggregates.Profile;
import com.IoTeam.ThirstySeedAPI.profile.domain.model.queries.GetAllProfilesQuery;
import com.IoTeam.ThirstySeedAPI.profile.domain.model.queries.GetProfileByEmailQuery;
import com.IoTeam.ThirstySeedAPI.profile.domain.model.queries.GetProfileByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
    Optional<Profile> handle(GetProfileByEmailQuery query);

    Optional<Profile> handle(GetProfileByIdQuery query);

    List<Profile> handle(GetAllProfilesQuery query);
}
