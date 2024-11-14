package com.IoTeam.ThirstySeedAPI.subscription.application.internal.commandservices;

import com.IoTeam.ThirstySeedAPI.iam.domain.model.aggregates.User;
import com.IoTeam.ThirstySeedAPI.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import com.IoTeam.ThirstySeedAPI.subscription.domain.model.aggregates.Subscription;
import com.IoTeam.ThirstySeedAPI.subscription.domain.model.commands.CreateSubscriptionCommand;
import com.IoTeam.ThirstySeedAPI.subscription.domain.services.SubscriptionCommandService;
import com.IoTeam.ThirstySeedAPI.subscription.infrastructure.persistence.jpa.repositories.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionCommandServiceImpl implements SubscriptionCommandService {

    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;

    public SubscriptionCommandServiceImpl(SubscriptionRepository subscriptionRepository, UserRepository userRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Subscription> handle(CreateSubscriptionCommand command) {
        // Verificar si el UserID existe antes de crear la Subscription
        Optional<User> optionalUser = userRepository.findById(command.userId());
        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("User with ID " + command.userId() + " does not exist.");
        }
        User user = optionalUser.get();

        // Validar si ya existe una suscripción activa para el usuario
        subscriptionRepository.findByUserAndActive(user, true).ifPresent(subscription -> {
            throw new IllegalArgumentException("User with ID " + command.userId() + " already has an active subscription.");
        });

        // Crear una nueva instancia de Subscription con los datos del comando
        Subscription subscription = new Subscription(
                user,
                command.planType(),
                command.nodeCount(),
                command.validationCode()
        );

        // Guardar la suscripción en el repositorio
        subscriptionRepository.save(subscription);
        return Optional.of(subscription);
    }
}