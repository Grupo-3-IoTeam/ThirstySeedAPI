package com.IoTeam.ThirstySeedAPI.profile.interfaces.rest.resources;

public record ProfileResource(Long id,
                              Long userId,
                              String fullName,
                              String email,
                              String phoneNumber,
                              String profileImage,
                              String location) {
}
