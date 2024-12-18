package com.IoTeam.ThirstySeedAPI.subscription.interfaces.rest.transform;

import com.IoTeam.ThirstySeedAPI.subscription.domain.model.commands.CreateSubscriptionCommand;
import com.IoTeam.ThirstySeedAPI.subscription.interfaces.rest.resources.CreateSubscriptionResource;

public class CreateSubscriptionCommandFromResourceAssembler {
    public static CreateSubscriptionCommand toCommandFromResource(CreateSubscriptionResource resource) {
        return new CreateSubscriptionCommand(
                resource.userId(),
                resource.planType(),
                resource.nodeCount(),
                resource.validationCode()
        );
    }
}
