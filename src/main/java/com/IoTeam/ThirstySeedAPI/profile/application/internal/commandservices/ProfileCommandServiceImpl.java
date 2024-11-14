package com.IoTeam.ThirstySeedAPI.profile.application.internal.commandservices;

import com.IoTeam.ThirstySeedAPI.iam.domain.model.aggregates.User;
import com.IoTeam.ThirstySeedAPI.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Plot;
import com.IoTeam.ThirstySeedAPI.profile.domain.model.aggregates.Profile;
import com.IoTeam.ThirstySeedAPI.profile.domain.model.commands.CreateProfileCommand;
import com.IoTeam.ThirstySeedAPI.profile.domain.model.valueobjects.EmailAddress;
import com.IoTeam.ThirstySeedAPI.profile.domain.services.ProfileCommandService;
import com.IoTeam.ThirstySeedAPI.profile.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public ProfileCommandServiceImpl(ProfileRepository profileRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Profile> handle(CreateProfileCommand command) {
        // Verificar si UserID existe antes de crear el Profile
        Optional<User> optionalUser = userRepository.findById(command.userId());
        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("User with ID " + command.userId() + " does not exist.");
        }
        User user = optionalUser.get();

        var emailAddress = new EmailAddress(command.email());
        profileRepository.findByEmail(emailAddress).map(profile -> {
            throw new IllegalArgumentException("Profile with email " + command.email() + " already exists");
        });
        var profile = new Profile(user, command);
        profileRepository.save(profile);
        return Optional.of(profile);
    }
}
