package com.IoTeam.ThirstySeedAPI.subscription.interfaces.rest.resources;

import com.IoTeam.ThirstySeedAPI.subscription.domain.model.valueobjects.PlanType;

public record CreateSubscriptionResource(
        Long userId,
        PlanType planType,
        Integer nodeCount,
        String validationCode
) {}
