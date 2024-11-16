package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest;

import com.IoTeam.ThirstySeedAPI.irrigation.application.internal.commandservices.PlotCommandServiceImpl;
import com.IoTeam.ThirstySeedAPI.irrigation.application.internal.queryservices.PlotQueryServiceImpl;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.DeletePlotCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.NotSupplyPlotCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.SupplyPlotCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetPlotByIdQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources.CreatePlotResource;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources.PlotResource;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources.UpdatePlotResource;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.transform.CreatePlotCommandFromResourceAssembler;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.transform.PlotResourceFromEntityAssembler;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.transform.UpdatePlotCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/plot", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Plots", description = "Plot Management Endpoints")
public class PlotController {
    private final PlotQueryServiceImpl plotQueryServiceImpl;
    private final PlotCommandServiceImpl plotCommandServiceImpl;

    public PlotController(PlotQueryServiceImpl plotQueryServiceImpl, PlotCommandServiceImpl plotCommandServiceImpl) {
        this.plotQueryServiceImpl = plotQueryServiceImpl;
        this.plotCommandServiceImpl = plotCommandServiceImpl;
    }

    @PostMapping
    public ResponseEntity<PlotResource> createPlot(@RequestBody CreatePlotResource resource) {
        try {
            var createPlotCommand = CreatePlotCommandFromResourceAssembler.toCommandFromResource(resource);
            var plotId = plotCommandServiceImpl.createPlot(createPlotCommand);
            if (plotId == 0L) {
                return ResponseEntity.badRequest().build();
            }
            var getPlotByIdQuery = new GetPlotByIdQuery(plotId);
            var plot = plotQueryServiceImpl.findPlotById(getPlotByIdQuery);

            if (plot.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }

            var plotResource = PlotResourceFromEntityAssembler.toResourceFromEntity(plot.get());
            return new ResponseEntity<>(plotResource, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{plotId}")
    public ResponseEntity<PlotResource> getPlotById(@PathVariable Long plotId) {
        var getPlotByIdQuery = new GetPlotByIdQuery(plotId);
        var plot = plotQueryServiceImpl.findPlotById(getPlotByIdQuery);
        if (plot.isEmpty()) return ResponseEntity.badRequest().build();
        var plotResource = PlotResourceFromEntityAssembler.toResourceFromEntity(plot.get());
        return ResponseEntity.ok(plotResource);
    }

    @GetMapping
    public ResponseEntity<List<PlotResource>> getPlots() {
        var listPlots = plotQueryServiceImpl.findAllPlots();
        List<PlotResource> plotResources = listPlots.stream()
                .map(PlotResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(plotResources);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<PlotResource>> getPlotsByUserId(@PathVariable Long userId) {
        var listPlots = plotQueryServiceImpl.findPlotsByUserId(userId);
        List<PlotResource> plotResources = listPlots.stream()
                .map(PlotResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(plotResources);
    }

    @PutMapping("/{plotId}/stocks")
    public ResponseEntity<Void> supplyPlot(@PathVariable Long plotId) {
        try {
            plotCommandServiceImpl.updateToPlotSupply(new SupplyPlotCommand(plotId));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{plotId}/outages")
    public ResponseEntity<Void> notSupplyPlot(@PathVariable Long plotId) {
        try {
            plotCommandServiceImpl.updateToPlotNotSupply(new NotSupplyPlotCommand(plotId));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{plotId}")
    public ResponseEntity<Void> updatePlot(@PathVariable Long plotId, @RequestBody UpdatePlotResource resource) {
        try {
            var updatePlotCommand = UpdatePlotCommandFromResourceAssembler.toCommand(plotId, resource);
            plotCommandServiceImpl.updatePlot(updatePlotCommand);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{plotId}")
    public ResponseEntity<Void> deleteNode(@PathVariable Long plotId) {
        try {
            DeletePlotCommand deletePlotCommand = new DeletePlotCommand(plotId);
            plotCommandServiceImpl.deletePlot(deletePlotCommand);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
