package com.IoTeam.ThirstySeedAPI.subscription.domain.model.commands;

import com.IoTeam.ThirstySeedAPI.subscription.domain.model.valueobjects.PlanType;
import com.IoTeam.ThirstySeedAPI.subscription.domain.model.valueobjects.NodeCount;
import com.IoTeam.ThirstySeedAPI.subscription.domain.model.valueobjects.ValidationCode;

public record CreateSubscriptionCommand(
        Long userId,
        PlanType planType,
        int nodeCount,
        String validationCode
) {}
