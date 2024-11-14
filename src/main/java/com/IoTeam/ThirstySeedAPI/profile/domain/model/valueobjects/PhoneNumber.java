package com.IoTeam.ThirstySeedAPI.profile.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record PhoneNumber(String number) {
    public PhoneNumber(){
        this(null);
    }

    public PhoneNumber {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("Phone number cannot be null or blank");
        }
    }
}