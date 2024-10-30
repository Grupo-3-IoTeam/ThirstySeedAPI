package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects;


import jakarta.persistence.Embeddable;

@Embeddable
public record Size(Integer size) {

    public Size() {
        this(1); // Default to 1 or another sensible default instead of 0
    }

    public Size {
        if (size == null || size <= 0) {
            throw new IllegalArgumentException("Size value must be more than zero");
        }
    }
}
