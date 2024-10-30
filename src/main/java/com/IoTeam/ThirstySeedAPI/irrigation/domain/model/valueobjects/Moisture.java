package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects;


import jakarta.persistence.Embeddable;

@Embeddable
public record Moisture(Integer moisture) {

    public Moisture() {
        this(0);
    }

    public Moisture {
        if (moisture < 0 || moisture > 100) {
            throw new IllegalArgumentException("Moisture must be between 0 and 100");
        }
    }
}
