package com.IoTeam.ThirstySeedAPI.profile.application.internal.queryservices;

import com.IoTeam.ThirstySeedAPI.profile.domain.model.aggregates.Profile;
import com.IoTeam.ThirstySeedAPI.profile.domain.model.queries.GetAllProfilesQuery;
import com.IoTeam.ThirstySeedAPI.profile.domain.model.queries.GetProfileByEmailQuery;
import com.IoTeam.ThirstySeedAPI.profile.domain.model.queries.GetProfileByIdQuery;
import com.IoTeam.ThirstySeedAPI.profile.domain.model.queries.GetProfileByUserIdQuery;
import com.IoTeam.ThirstySeedAPI.profile.domain.services.ProfileQueryService;
import com.IoTeam.ThirstySeedAPI.profile.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {
    private final ProfileRepository profileRepository;

    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Profile> handle(GetProfileByEmailQuery query) {
        return profileRepository.findByEmail(query.emailAddress());
    }

    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return profileRepository.findById(query.profileId());
    }

    @Override
    public List<Profile> handle(GetAllProfilesQuery query) {
        return profileRepository.findAll();
    }

    @Override
    public Optional<Profile> handle(GetProfileByUserIdQuery query) {
        return profileRepository.findByUserId(query.userId());
    }
}
