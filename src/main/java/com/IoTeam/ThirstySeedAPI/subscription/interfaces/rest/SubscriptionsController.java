package com.IoTeam.ThirstySeedAPI.subscription.interfaces.rest;

import com.IoTeam.ThirstySeedAPI.subscription.domain.model.commands.DeleteSubscriptionByIdCommand;
import com.IoTeam.ThirstySeedAPI.subscription.domain.model.queries.GetSubscriptionByUserIdQuery;
import com.IoTeam.ThirstySeedAPI.subscription.domain.services.SubscriptionCommandService;
import com.IoTeam.ThirstySeedAPI.subscription.domain.services.SubscriptionQueryService;
import com.IoTeam.ThirstySeedAPI.subscription.interfaces.rest.resources.CreateSubscriptionResource;
import com.IoTeam.ThirstySeedAPI.subscription.interfaces.rest.resources.SubscriptionResource;
import com.IoTeam.ThirstySeedAPI.subscription.interfaces.rest.transform.CreateSubscriptionCommandFromResourceAssembler;
import com.IoTeam.ThirstySeedAPI.subscription.interfaces.rest.transform.SubscriptionResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/subscriptions", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Subscriptions", description = "Subscription Management Endpoints")
public class SubscriptionsController {

    private final SubscriptionCommandService subscriptionCommandService;
    private final SubscriptionQueryService subscriptionQueryService;

    public SubscriptionsController(SubscriptionCommandService subscriptionCommandService, SubscriptionQueryService subscriptionQueryService) {
        this.subscriptionCommandService = subscriptionCommandService;
        this.subscriptionQueryService = subscriptionQueryService;
    }

    /**
     * Creates a new Subscription
     * @param resource the resource containing the data to create the Subscription
     * @return the created Subscription
     */
    @PostMapping
    public ResponseEntity<SubscriptionResource> createSubscription(@RequestBody CreateSubscriptionResource resource) {
        var createSubscriptionCommand = CreateSubscriptionCommandFromResourceAssembler.toCommandFromResource(resource);
        var subscription = subscriptionCommandService.handle(createSubscriptionCommand);
        if (subscription.isEmpty()) return ResponseEntity.badRequest().build();
        var subscriptionResource = SubscriptionResourceFromEntityAssembler.toResourceFromEntity(subscription.get());
        return new ResponseEntity<>(subscriptionResource, HttpStatus.CREATED);
    }

    /**
     * Gets a Subscription by its user id
     * @param userId the user ID of the Subscription to get
     * @return the Subscription resource associated with the given user ID
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<SubscriptionResource> getSubscriptionByUserId(@PathVariable Long userId) {
        var query = new GetSubscriptionByUserIdQuery(userId);
        var subscription = subscriptionQueryService.handle(query);
        if (subscription.isEmpty()) return ResponseEntity.badRequest().build();
        var subscriptionResource = SubscriptionResourceFromEntityAssembler.toResourceFromEntity(subscription.get());
        return ResponseEntity.ok(subscriptionResource);
    }

    /**
     * Deletes a Subscription by its ID
     * @param subscriptionId the ID of the Subscription to delete
     * @return a response entity with the result of the operation
     */
    @DeleteMapping("/{subscriptionId}")
    public ResponseEntity<Void> deleteSubscriptionById(@PathVariable Long subscriptionId) {
         var deleteSubscriptionByIdCommand = new DeleteSubscriptionByIdCommand(subscriptionId);
         subscriptionCommandService.handle(deleteSubscriptionByIdCommand);
         return ResponseEntity.noContent().build();
    }
}
