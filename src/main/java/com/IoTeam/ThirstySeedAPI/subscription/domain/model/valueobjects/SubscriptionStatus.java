package com.IoTeam.ThirstySeedAPI.subscription.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record SubscriptionStatus(String status) {
    public SubscriptionStatus() { this(null); }

    public static SubscriptionStatus PENDING() { return new SubscriptionStatus("PENDING"); }
    public static SubscriptionStatus ACTIVE() { return new SubscriptionStatus("ACTIVE"); }
    public static SubscriptionStatus EXPIRED() { return new SubscriptionStatus("EXPIRED"); }
}
