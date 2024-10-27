package com.IoTeam.ThirstySeedAPI.datamanagement.plot.interfaces;

import com.IoTeam.ThirstySeedAPI.datamanagement.plot.application.internal.commandservices.PlotCommandServiceImpl;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.application.internal.queryservices.PlotQueryServiceImpl;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.model.commands.NotSupplyPlotCommand;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.model.commands.SupplyPlotCommand;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.model.queries.GetPlotByIdQuery;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.interfaces.resources.CreatePlotResource;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.interfaces.resources.PlotResource;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.interfaces.transform.CreatePlotCommandFromResourceAssembler;
import com.IoTeam.ThirstySeedAPI.datamanagement.plot.interfaces.transform.PlotResourceFromEntityAssembler;

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


    @PutMapping("/{plotId}/supply")
    public ResponseEntity<Void> supplyPlot(@PathVariable Long plotId) {
        try {
            plotCommandServiceImpl.updateToPlotSupply(new SupplyPlotCommand(plotId));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PutMapping("/{plotId}/not-supply")
    public ResponseEntity<Void> notSupplyPlot(@PathVariable Long plotId) {
        try {
            plotCommandServiceImpl.updateToPlotNotSupply(new NotSupplyPlotCommand(plotId));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
