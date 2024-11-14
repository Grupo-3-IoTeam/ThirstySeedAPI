package com.IoTeam.ThirstySeedAPI.profile.interfaces.rest.resources;

public record CreateProfileResource(
        Long userId,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String profileImage,
        String location) {
}
