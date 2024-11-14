package com.IoTeam.ThirstySeedAPI.subscription.domain.model.commands;

import com.IoTeam.ThirstySeedAPI.subscription.domain.model.valueobjects.PlanType;

public record CreateSubscriptionCommand(
        Long userId,
        PlanType planType,
        int nodeCount,
        String validationCode
) {}
