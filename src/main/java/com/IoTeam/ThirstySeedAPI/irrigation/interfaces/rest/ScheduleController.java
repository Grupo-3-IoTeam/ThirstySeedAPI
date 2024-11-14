package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest;

import com.IoTeam.ThirstySeedAPI.irrigation.application.internal.commandservices.ScheduleCommandServiceImpl;
import com.IoTeam.ThirstySeedAPI.irrigation.application.internal.queryservices.ScheduleQueryServiceImpl;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.DeleteScheduleCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetAllSchedulesQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetScheduleByIdQuery;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/schedules", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Schedules", description = "Schedule Management Endpoints")
public class ScheduleController {

    private final ScheduleCommandServiceImpl scheduleCommandServiceImpl;
    private final ScheduleQueryServiceImpl scheduleQueryServiceImpl;

    public ScheduleController(ScheduleCommandServiceImpl scheduleCommandServiceImpl, ScheduleQueryServiceImpl scheduleQueryServiceImpl) {
        this.scheduleCommandServiceImpl = scheduleCommandServiceImpl;
        this.scheduleQueryServiceImpl = scheduleQueryServiceImpl;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping
    public ResponseEntity<ScheduleResource> createSchedule(@RequestBody CreateScheduleResource resource) {
        try {
            var createScheduleCommand = CreateScheduleCommandFromResourceAssembler.toCommandFromResource(resource);
            var scheduleId = scheduleCommandServiceImpl.handle(createScheduleCommand);
            if (scheduleId == 0L) {
                return ResponseEntity.badRequest().build();
            }
            var getScheduleByIdQuery = new GetScheduleByIdQuery(scheduleId);
            var schedule = scheduleQueryServiceImpl.handle(getScheduleByIdQuery);

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

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResource> getScheduleById(@PathVariable Long scheduleId) {
        var getScheduleByIdQuery = new GetScheduleByIdQuery(scheduleId);
        var schedule = scheduleQueryServiceImpl.handle(getScheduleByIdQuery);
        if (schedule.isEmpty()) return ResponseEntity.badRequest().build();
        var scheduleResource = ScheduleResourceFromEntityAssembler.toResourceFromEntity(schedule.get());
        return ResponseEntity.ok(scheduleResource);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public ResponseEntity<List<ScheduleResource>> getAllSchedules() {
        var query = new GetAllSchedulesQuery();
        var listSchedules = scheduleQueryServiceImpl.handle(query);
        List<ScheduleResource> scheduleResources = listSchedules.stream()
                .map(ScheduleResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(scheduleResources);
    }

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long scheduleId) {
        try {
            var deleteScheduleCommand = new DeleteScheduleCommand(scheduleId);
            scheduleCommandServiceImpl.handle(deleteScheduleCommand);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PreAuthorize("isAuthenticated()")
    @PutMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResource> updateSchedule(
            @PathVariable Long scheduleId,
            @RequestBody UpdateScheduleResource resource) {
        try {

            var updateScheduleCommand = UpdateScheduleCommandFromResourceAssembler.toCommandFromResource(scheduleId, resource);


            scheduleCommandServiceImpl.handle(updateScheduleCommand);


            var getScheduleByIdQuery = new GetScheduleByIdQuery(scheduleId);
            var updatedSchedule = scheduleQueryServiceImpl.handle(getScheduleByIdQuery);


            if (updatedSchedule.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }


            var scheduleResource = ScheduleResourceFromEntityAssembler.toResourceFromEntity(updatedSchedule.get());


            return ResponseEntity.ok(scheduleResource);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
