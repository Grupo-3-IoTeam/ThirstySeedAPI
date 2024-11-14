package com.IoTeam.ThirstySeedAPI.profile.domain.model.valueobjects;


import jakarta.persistence.Embeddable;

@Embeddable
public record ProfileImage(String imageUrl) {
    public ProfileImage(){
        this(null);
    }

    public ProfileImage {
        if (imageUrl == null || imageUrl.isBlank()) {
            throw new IllegalArgumentException("Profile image cannot be null or blank");
        }
    }
}