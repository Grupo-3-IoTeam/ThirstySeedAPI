package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record IsActive(Boolean value) {
    public IsActive() {
        this(null);
    }

    public IsActive {
        if (value == null) {
            throw new IllegalArgumentException("IsActive cannot be null");
        }
    }
}