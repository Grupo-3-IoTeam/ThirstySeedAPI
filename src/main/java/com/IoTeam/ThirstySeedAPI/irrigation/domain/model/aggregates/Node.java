package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Node extends AbstractAggregateRoot<Node> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plot_id")
    @Getter
    @Setter
    private Plot plot;

    @Embedded
    @Getter
    @Setter
    private NodeLocation nodelocation;

    @Embedded
    @Getter
    @Setter
    private Moisture moisture;

    @Embedded
    @Getter
    @Setter
    private Indicator indicator;

    @Embedded
    @Getter
    @Setter
    private Status status;

    @Embedded
    @Getter
    @Setter
    private StatusClass statusClass;

    @Embedded
    @Getter
    @Setter
    private IconClass iconClass;

    @Embedded
    @Getter
    @Setter
    private IsActive isActive;


    public Node(Plot plot, NodeLocation nodelocation, Moisture moisture, Indicator indicator, Status status, StatusClass statusClass, IconClass iconClass, IsActive isActive) {
        this.plot = plot;
        this.nodelocation = nodelocation;
        this.moisture = moisture;
        this.indicator = indicator;
        this.status = status;
        this.statusClass = statusClass;
        this.iconClass = iconClass;
        this.isActive = isActive;
    }


    public Node() {

    }



}
