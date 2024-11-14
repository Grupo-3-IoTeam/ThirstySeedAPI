package com.IoTeam.ThirstySeedAPI.profile.domain.model.commands;

public record CreateProfileCommand(
        Long userId,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String profileImage,
        String location)
{ }

