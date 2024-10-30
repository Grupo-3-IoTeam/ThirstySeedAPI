package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record NodeLocation(String nodelocation) {
    public NodeLocation(){
        this(null);
    }

    public NodeLocation {
        if (nodelocation == null || nodelocation.isBlank()) {
            throw new IllegalArgumentException("Location cannot be null or blank");
        }

    }


}
