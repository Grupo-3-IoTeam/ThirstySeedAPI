package com.IoTeam.ThirstySeedAPI.profile.infrastructure.persistence.jpa.repositories;

import com.IoTeam.ThirstySeedAPI.profile.domain.model.aggregates.Profile;
import com.IoTeam.ThirstySeedAPI.profile.domain.model.valueobjects.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByEmail(EmailAddress emailAddress);
    Optional<Profile> findByUser_Id(Long userId);
}
