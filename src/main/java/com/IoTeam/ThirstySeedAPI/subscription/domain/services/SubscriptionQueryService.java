package com.IoTeam.ThirstySeedAPI.subscription.domain.services;

import com.IoTeam.ThirstySeedAPI.subscription.domain.model.aggregates.Subscription;
import com.IoTeam.ThirstySeedAPI.subscription.domain.model.queries.GetSubscriptionByUserIdQuery;

import java.util.Optional;

public interface SubscriptionQueryService {
    Optional<Subscription> handle(GetSubscriptionByUserIdQuery query);
}
