package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest;

import com.IoTeam.ThirstySeedAPI.irrigation.application.internal.commandservices.ScheduleCommandServiceImpl;
import com.IoTeam.ThirstySeedAPI.irrigation.application.internal.queryservices.ScheduleQueryServiceImpl;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.DeleteScheduleCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetAllSchedulesQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetScheduleByIdQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetSchedulesByPlotIdQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetSchedulesByUserIdQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.services.commands.ScheduleCommandService;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.services.queries.ScheduleQueryService;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources.CreateScheduleResource;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources.ScheduleResource;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources.UpdateScheduleResource;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.transform.CreateScheduleCommandFromResourceAssembler;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.transform.ScheduleResourceFromEntityAssembler;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.transform.UpdateScheduleCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/schedules", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Schedules", description = "Schedule Management Endpoints")
public class ScheduleController {

    private final ScheduleCommandService scheduleCommandService;
    private final ScheduleQueryService scheduleQueryService;

    public ScheduleController(ScheduleCommandService scheduleCommandService, ScheduleQueryService scheduleQueryService) {
        this.scheduleCommandService = scheduleCommandService;
        this.scheduleQueryService = scheduleQueryService;
    }


    @PostMapping
    public ResponseEntity<ScheduleResource> createSchedule(@RequestBody CreateScheduleResource resource) {
        try {
            var createScheduleCommand = CreateScheduleCommandFromResourceAssembler.toCommandFromResource(resource);
            var scheduleId = scheduleCommandService.handle(createScheduleCommand);
            if (scheduleId == 0L) {
                return ResponseEntity.badRequest().build();
            }
            var getScheduleByIdQuery = new GetScheduleByIdQuery(scheduleId);
            var schedule = scheduleQueryService.handle(getScheduleByIdQuery);

            if (schedule.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }

            var scheduleResource = ScheduleResourceFromEntityAssembler.toResourceFromEntity(schedule.get());
            return new ResponseEntity<>(scheduleResource, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResource> getScheduleById(@PathVariable Long scheduleId) {
        var getScheduleByIdQuery = new GetScheduleByIdQuery(scheduleId);
        var schedule = scheduleQueryService.handle(getScheduleByIdQuery);
        if (schedule.isEmpty()) return ResponseEntity.badRequest().build();
        var scheduleResource = ScheduleResourceFromEntityAssembler.toResourceFromEntity(schedule.get());
        return ResponseEntity.ok(scheduleResource);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResource>> getAllSchedules() {
        var query = new GetAllSchedulesQuery();
        var listSchedules = scheduleQueryService.handle(query);
        List<ScheduleResource> scheduleResources = listSchedules.stream()
                .map(ScheduleResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(scheduleResources);
    }

    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long scheduleId) {
        try {
            var deleteScheduleCommand = new DeleteScheduleCommand(scheduleId);
            scheduleCommandService.handle(deleteScheduleCommand);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResource> updateSchedule(
            @PathVariable Long scheduleId,
            @RequestBody UpdateScheduleResource resource) {
        try {
            var updateScheduleCommand = UpdateScheduleCommandFromResourceAssembler.toCommandFromResource(scheduleId, resource);
            scheduleCommandService.handle(updateScheduleCommand);
            var getScheduleByIdQuery = new GetScheduleByIdQuery(scheduleId);
            var schedule = scheduleQueryService.handle(getScheduleByIdQuery);
            if (schedule.isEmpty()) return ResponseEntity.badRequest().build();
            var scheduleResource = ScheduleResourceFromEntityAssembler.toResourceFromEntity(schedule.get());
            return ResponseEntity.ok(scheduleResource);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Nuevo endpoint para obtener los horarios por plotId
    @GetMapping("/plot/{plotId}")
    public ResponseEntity<List<ScheduleResource>> getSchedulesByPlotId(@PathVariable Long plotId) {
        try {
            var query = new GetSchedulesByPlotIdQuery(plotId);
            var listSchedules = scheduleQueryService.handle(query);
            List<ScheduleResource> scheduleResources = listSchedules.stream()
                    .map(ScheduleResourceFromEntityAssembler::toResourceFromEntity)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(scheduleResources);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Nuevo endpoint para obtener los horarios por userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ScheduleResource>> getSchedulesByUserId(@PathVariable Long userId) {
        try {
            var query = new GetSchedulesByUserIdQuery(userId);
            var listSchedules = scheduleQueryService.handle(query);
            List<ScheduleResource> scheduleResources = listSchedules.stream()
                    .map(ScheduleResourceFromEntityAssembler::toResourceFromEntity)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(scheduleResources);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
