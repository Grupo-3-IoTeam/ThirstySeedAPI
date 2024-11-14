package com.IoTeam.ThirstySeedAPI.subscription.application.internal.queryservices;

import com.IoTeam.ThirstySeedAPI.iam.domain.model.aggregates.User;
import com.IoTeam.ThirstySeedAPI.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import com.IoTeam.ThirstySeedAPI.subscription.domain.model.aggregates.Subscription;
import com.IoTeam.ThirstySeedAPI.subscription.domain.model.queries.GetSubscriptionByUserIdQuery;
import com.IoTeam.ThirstySeedAPI.subscription.domain.services.SubscriptionQueryService;
import com.IoTeam.ThirstySeedAPI.subscription.infrastructure.persistence.jpa.repositories.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionQueryServiceImpl implements SubscriptionQueryService {
    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;

    public SubscriptionQueryServiceImpl(SubscriptionRepository subscriptionRepository, UserRepository userRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Subscription> handle(GetSubscriptionByUserIdQuery query) {
        // Buscar el usuario usando userId
        Optional<User> user = userRepository.findById(query.userId());
        if (user.isEmpty()) {
            return Optional.empty();
        }
        // Buscar la suscripción usando el usuario encontrado
        return subscriptionRepository.findByUser(user.get());
    }
}
