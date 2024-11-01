package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record IsAutomatic(Boolean isAutomatic) {
    public IsAutomatic() {
        this(null);
    }

    public IsAutomatic {
        if (isAutomatic == null) {
            throw new IllegalArgumentException("IsActive cannot be null");
        }
    }
}
