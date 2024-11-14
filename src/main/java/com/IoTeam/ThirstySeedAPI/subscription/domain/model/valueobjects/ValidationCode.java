package com.IoTeam.ThirstySeedAPI.subscription.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ValidationCode(String code) {
    public ValidationCode() { this(null); }
}
