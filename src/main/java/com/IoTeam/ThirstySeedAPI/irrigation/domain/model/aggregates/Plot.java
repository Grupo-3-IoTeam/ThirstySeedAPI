package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates;

import com.IoTeam.ThirstySeedAPI.iam.domain.model.aggregates.User;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects.*;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Plot extends AbstractAggregateRoot<Plot> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private User user;

    @Setter
    @Getter
    @Embedded
    private Name name;

    @Setter
    @Getter
    @Embedded
    private Location location;

    @Setter
    @Getter
    @Embedded
    private Extension extension;
    @Setter
    @Getter
    @Embedded
    private Size size;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    private PlotStatus plotStatus;
    @Setter
    @Getter
    @Embedded
    private ImageUrl imageUrl;

    @Getter
    @CreatedDate
    private Date createdAt;


    @Getter
    @LastModifiedDate
    private Date updatedAt;

    public Plot(User user, Name name, Location location, Extension extension, Size size, PlotStatus plotStatus, ImageUrl imageUrl) {
        this.user = user;
        this.name = name;
        this.location = location;
        this.extension = extension;
        this.size = size;
        this.plotStatus = PlotStatus.REQUESTED;
        this.imageUrl = imageUrl;
    }

    public Plot() {}
    public void supply() {
        this.plotStatus = PlotStatus.SUPPLIED;
    }
    public void not_supply() {
        this.plotStatus = PlotStatus.NOT_SUPPLIED;
    }
}
