package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.CreateScheduleCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Schedule extends AbstractAggregateRoot<Schedule> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plot_id")
    @Setter
    private Plot plot;

    @Embedded
    @Setter
    private WaterAmount waterAmount;

    @Embedded
    @Setter
    private Pressure pressure;

    @Embedded
    @Setter
    private SprinklerRadius sprinklerRadius;

    @Embedded
    @Setter
    private MoistureLevel expectedMoisture;

    @Embedded
    @Setter
    private IrrigationDuration estimatedTime;

    @Embedded
    @Setter
    private IrrigationTime setTime;

    @Embedded
    @Setter
    private SprinklerAngle angle;

    @Embedded
    @Setter
    private IsAutomatic isAutomatic;

    public Schedule() {
        this.waterAmount = new WaterAmount(1);
        this.pressure = new Pressure(1);
        this.sprinklerRadius = new SprinklerRadius(1);
        this.expectedMoisture = new MoistureLevel(1);
        this.estimatedTime = new IrrigationDuration(1);
        this.setTime = new IrrigationTime("12:00 AM");
        this.angle = new SprinklerAngle(1);
        this.isAutomatic = new IsAutomatic(true);
    }

    public Schedule(Plot plot, WaterAmount waterAmount, Pressure pressureValue, SprinklerRadius sprinklerRadius,
                    MoistureLevel expectedMoisture, IrrigationDuration estimatedTime, IrrigationTime setTime,
                    SprinklerAngle angle, IsAutomatic isAutomatic) {
        this();
        this.plot = plot;
        this.waterAmount = waterAmount;
        this.pressure = pressureValue;
        this.sprinklerRadius = sprinklerRadius;
        this.expectedMoisture = expectedMoisture;
        this.estimatedTime = estimatedTime;
        this.setTime = setTime;
        this.angle = angle;
        this.isAutomatic = isAutomatic;
        validate();
    }

    public Schedule(Plot plot, CreateScheduleCommand command) {
        this(
                plot,
                new WaterAmount(command.waterAmount()),
                new Pressure(command.pressure()),
                new SprinklerRadius(command.sprinklerRadius()),
                new MoistureLevel(command.expectedMoisture()),
                new IrrigationDuration(command.estimatedTimeHours()),
                new IrrigationTime(command.setTime()),
                new SprinklerAngle(command.angle()),
                new IsAutomatic(command.isAutomatic())
        );
    }

    public Schedule updateDetails(WaterAmount waterAmount, Pressure pressure, SprinklerRadius sprinklerRadius,
                                  MoistureLevel expectedMoisture, IrrigationDuration estimatedTime,
                                  IrrigationTime setTime, SprinklerAngle angle, IsAutomatic isAutomatic) {
        this.waterAmount = waterAmount;
        this.pressure = pressure;
        this.sprinklerRadius = sprinklerRadius;
        this.expectedMoisture = expectedMoisture;
        this.estimatedTime = estimatedTime;
        this.setTime = setTime;
        this.angle = angle;
        this.isAutomatic = isAutomatic;
        validate();
        return this;
    }

    private void validate() {
        // TODO Add business rules
    }
}