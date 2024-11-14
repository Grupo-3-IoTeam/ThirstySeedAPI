package com.IoTeam.ThirstySeedAPI.subscription.rest.resources;

public record SubscriptionResource(
        Long id,
        Long userId,
        String planType,
        Integer nodeCount,
        String validationCode,
        boolean active
) {}
