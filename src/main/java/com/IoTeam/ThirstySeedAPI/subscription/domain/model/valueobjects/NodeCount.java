package com.IoTeam.ThirstySeedAPI.subscription.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record NodeCount(int count) {
    public NodeCount() { this(0); }
}
