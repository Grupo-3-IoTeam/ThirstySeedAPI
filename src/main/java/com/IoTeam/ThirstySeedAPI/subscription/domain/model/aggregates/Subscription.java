package com.IoTeam.ThirstySeedAPI.subscription.domain.model.aggregates;

import com.IoTeam.ThirstySeedAPI.iam.domain.model.aggregates.User;
import com.IoTeam.ThirstySeedAPI.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.IoTeam.ThirstySeedAPI.subscription.domain.model.valueobjects.NodeCount;
import com.IoTeam.ThirstySeedAPI.subscription.domain.model.valueobjects.PlanType;
import com.IoTeam.ThirstySeedAPI.subscription.domain.model.valueobjects.ValidationCode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Subscription extends AuditableAbstractAggregateRoot<Subscription> {

    @OneToOne
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private User user;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private PlanType planType;

    @Embedded
    @Getter
    @Setter
    private NodeCount nodeCount;

    @Embedded
    @Getter
    @Setter
    private ValidationCode validationCode;

    @Getter
    @Setter
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