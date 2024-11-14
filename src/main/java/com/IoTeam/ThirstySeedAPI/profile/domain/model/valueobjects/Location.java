package com.IoTeam.ThirstySeedAPI.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Location(String location) {
    public Location(){
        this(null);
    }

    public Location {
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Location cannot be null or blank");
        }
    }
}
