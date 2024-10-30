package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Indicator(String indicator) {
    public Indicator(){
        this(null);
    }

    public Indicator {
        if (indicator == null || indicator.isBlank()) {
            throw new IllegalArgumentException("Indicator cannot be null or blank");
        }

    }


}
