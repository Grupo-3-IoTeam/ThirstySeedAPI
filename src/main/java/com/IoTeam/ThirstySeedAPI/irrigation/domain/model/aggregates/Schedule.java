package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Schedule extends AbstractAggregateRoot<Node> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="plot_id")
    private Plot plot;

    @Embedded
    private WaterAmount waterAmount;

    @Embedded
    private Pressure pressure;

    @Embedded
    private SprinklerRadius sprinklerRadius;

    @Embedded
    private MoistureLevel expectedMoisture;

    @Embedded
    private IrrigationDuration estimatedTime;

    @Embedded
    private IrrigationTime setTime;

    @Embedded
    private SprinklerAngle angle;

    private boolean isAutomatic;

    public Schedule (){
        validate();
    }

    private void validate() {
        // TODO
    }
}
