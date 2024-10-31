package com.IoTeam.ThirstySeedAPI.irrigation.application.internal.commandservices;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Schedule;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.CreateScheduleCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.DeleteScheduleCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.UpdateScheduleCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects.*;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.services.commands.ScheduleCommandService;
import com.IoTeam.ThirstySeedAPI.irrigation.infrastructure.persistence.jpa.repositories.ScheduleRepository;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Plot;
import com.IoTeam.ThirstySeedAPI.irrigation.infrastructure.persistence.jpa.repositories.PlotRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScheduleCommandServiceImpl implements ScheduleCommandService {

    private final ScheduleRepository scheduleRepository;
    private final PlotRepository plotRepository;

    public ScheduleCommandServiceImpl(ScheduleRepository scheduleRepository, PlotRepository plotRepository) {
        this.scheduleRepository = scheduleRepository;
        this.plotRepository = plotRepository;
    }

    @Override
    public Long handle(CreateScheduleCommand command) {
        // Verificar si el Plot existe antes de crear el Schedule
        Optional<Plot> optionalPlot = plotRepository.findById(command.plotId());
        if (optionalPlot.isEmpty()) {
            throw new IllegalArgumentException("Plot with ID " + command.plotId() + " does not exist.");
        }
        Plot plot = optionalPlot.get();

        // Crear el Schedule con el constructor usando el comando
        var schedule = new Schedule(plot, command);
        try {
            scheduleRepository.save(schedule);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving schedule: " + e.getMessage());
        }
        return schedule.getId();
    }

    @Override
    public Optional<Schedule> handle(UpdateScheduleCommand command) {
        var scheduleOptional = scheduleRepository.findById(command.scheduleId());
        if (scheduleOptional.isEmpty()) {
            throw new IllegalArgumentException("Schedule does not exist");
        }

        var scheduleToUpdate = scheduleOptional.get();

        try {
            var updatedSchedule = scheduleRepository.save(
                    scheduleToUpdate.updateDetails(
                            new WaterAmount(command.waterAmount()),
                            new Pressure(command.pressure()),
                            new SprinklerRadius(command.sprinklerRadius()),
                            new MoistureLevel(command.expectedMoisture()),
                            new IrrigationDuration(command.estimatedTimeHours()),
                            new IrrigationTime(command.setTime()),
                            new SprinklerAngle(command.angle()),
                            new IsAutomatic(command.isAutomatic())
                    )
            );
            return Optional.of(updatedSchedule);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating schedule: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteScheduleCommand command) {
        if (!scheduleRepository.existsById(command.scheduleId())) {
            throw new IllegalArgumentException("Schedule does not exist");
        }
        try {
            scheduleRepository.deleteById(command.scheduleId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting schedule: " + e.getMessage());
        }
    }
}