package com.IoTeam.ThirstySeedAPI.subscription.interfaces.rest.resources;

public record SubscriptionResource(
        Long id,
        Long userId,
        String planType,
        Integer nodeCount,
        String validationCode,
        boolean active
) {}
