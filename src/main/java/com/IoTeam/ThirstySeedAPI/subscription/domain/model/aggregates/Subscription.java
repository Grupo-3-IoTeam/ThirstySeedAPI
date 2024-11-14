package com.IoTeam.ThirstySeedAPI.subscription.domain.model.aggregates;

import com.IoTeam.ThirstySeedAPI.iam.domain.model.aggregates.User;
import com.IoTeam.ThirstySeedAPI.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.IoTeam.ThirstySeedAPI.subscription.domain.model.valueobjects.NodeCount;
import com.IoTeam.ThirstySeedAPI.subscription.domain.model.valueobjects.PlanType;
import com.IoTeam.ThirstySeedAPI.subscription.domain.model.valueobjects.ValidationCode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Subscription extends AuditableAbstractAggregateRoot<Subscription> {

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private PlanType planType;

    @Embedded
    private NodeCount nodeCount;

    @Embedded
    private ValidationCode validationCode;

    private boolean active;

    public Subscription(User user, PlanType planType, int nodeCount, String validationCode) {
        this.user = user;
        this.planType = planType;
        this.nodeCount = new NodeCount(nodeCount);
        this.validationCode = new ValidationCode(validationCode);
        this.active = true;
    }

    public Subscription() {
    }

    public Long getUserId() {
        return user.getId();
    }

    public void deactivate() {
        this.active = false;
    }
}