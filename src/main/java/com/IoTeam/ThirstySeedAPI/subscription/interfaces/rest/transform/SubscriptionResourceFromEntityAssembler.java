package com.IoTeam.ThirstySeedAPI.subscription.interfaces.rest.transform;

import com.IoTeam.ThirstySeedAPI.subscription.domain.model.aggregates.Subscription;
import com.IoTeam.ThirstySeedAPI.subscription.interfaces.rest.resources.SubscriptionResource;

public class SubscriptionResourceFromEntityAssembler {
    public static SubscriptionResource toResourceFromEntity(Subscription entity) {
        return new SubscriptionResource(
                entity.getId(),
                entity.getUserId(),
                entity.getPlanType().name(),
                entity.getNodeCount().count(),
                entity.getValidationCode().code(),
                entity.isActive()
        );
    }
}
