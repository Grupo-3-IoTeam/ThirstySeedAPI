package com.IoTeam.ThirstySeedAPI.subscription.interfaces.rest.resources;

import com.IoTeam.ThirstySeedAPI.subscription.domain.model.valueobjects.PlanType;
import com.IoTeam.ThirstySeedAPI.subscription.domain.model.valueobjects.NodeCount;
import com.IoTeam.ThirstySeedAPI.subscription.domain.model.valueobjects.ValidationCode;

public record CreateSubscriptionResource(
        Long userId,
        PlanType planType,
        Integer nodeCount,
        String validationCode
) {}
