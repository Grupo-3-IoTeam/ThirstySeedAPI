package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record StatusClass(String statusClass) {
    public StatusClass(){
        this(null);
    }

    public StatusClass {
        if (statusClass == null || statusClass.isBlank()) {
            throw new IllegalArgumentException("Status Class cannot be null or blank");
        }

    }


}
