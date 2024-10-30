package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record IconClass(String iconClass) {
    public IconClass(){
        this(null);
    }

    public IconClass {
        if (iconClass == null || iconClass.isBlank()) {
            throw new IllegalArgumentException("Icon Class cannot be null or blank");
        }

    }


}
