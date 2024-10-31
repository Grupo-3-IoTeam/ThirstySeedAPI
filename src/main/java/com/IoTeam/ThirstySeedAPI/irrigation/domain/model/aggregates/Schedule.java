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

    @Setter
    private boolean isAutomatic;

    public Schedule() {
        this.waterAmount = new WaterAmount(0, "litros");
        this.pressure = new Pressure(0, "PSI");
        this.sprinklerRadius = new SprinklerRadius(0, "m");
        this.expectedMoisture = new MoistureLevel(0);
        this.estimatedTime = new IrrigationDuration(0);
        this.setTime = new IrrigationTime("00:00");
        this.angle = new SprinklerAngle(0);
        this.isAutomatic = false;
    }

    public Schedule(Plot plot, WaterAmount waterAmount, Pressure pressure, SprinklerRadius sprinklerRadius,
                    MoistureLevel expectedMoisture, IrrigationDuration estimatedTime, IrrigationTime setTime,
                    SprinklerAngle angle, boolean isAutomatic) {
        this();
        this.plot = plot;
        this.waterAmount = waterAmount;
        this.pressure = pressure;
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
                new WaterAmount(command.waterAmount(), "litros"),
                new Pressure(command.pressure(), "PSI"),
                new SprinklerRadius(command.sprinklerRadius(), "m"),
                new MoistureLevel(command.expectedMoisture()),
                new IrrigationDuration(command.estimatedTimeHours()),
                new IrrigationTime(command.setTime()),
                new SprinklerAngle(command.angle()),
                command.isAutomatic()
        );
    }

    public Schedule updateDetails(WaterAmount waterAmount, Pressure pressure, SprinklerRadius sprinklerRadius,
                                  MoistureLevel expectedMoisture, IrrigationDuration estimatedTime,
                                  IrrigationTime setTime, SprinklerAngle angle, boolean isAutomatic) {
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