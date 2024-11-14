package com.IoTeam.ThirstySeedAPI.subscription.domain.services;

import com.IoTeam.ThirstySeedAPI.subscription.domain.model.aggregates.Subscription;
import com.IoTeam.ThirstySeedAPI.subscription.domain.model.commands.CreateSubscriptionCommand;

import java.util.Optional;

public interface SubscriptionCommandService {
    Optional<Subscription> handle(CreateSubscriptionCommand command);
}
