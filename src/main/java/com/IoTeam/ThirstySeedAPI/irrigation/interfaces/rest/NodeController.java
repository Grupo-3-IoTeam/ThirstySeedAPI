package com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest;

import com.IoTeam.ThirstySeedAPI.irrigation.application.internal.commandservices.NodeCommandServiceImpl;
import com.IoTeam.ThirstySeedAPI.irrigation.application.internal.queryservices.NodeQueryServiceImpl;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetNodeByIdQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetNodeByPlotIdQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources.CreateNodeResource;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources.NodeResource;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.resources.UpdateNodeMoistureResource;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.transform.CreateNodeCommandFromResourceAssembler;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.transform.NodeResourceFromEntityAssembler;
import com.IoTeam.ThirstySeedAPI.irrigation.interfaces.rest.transform.UpdateNodeMoistureCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/node", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Nodes", description = "Node Management Endpoints")
public class NodeController {
    private final NodeQueryServiceImpl nodeQueryServiceImpl;
    private final NodeCommandServiceImpl nodeCommandServiceImpl;

    public NodeController(NodeQueryServiceImpl nodeQueryServiceImpl, NodeCommandServiceImpl nodeCommandServiceImpl) {
        this.nodeQueryServiceImpl = nodeQueryServiceImpl;
        this.nodeCommandServiceImpl = nodeCommandServiceImpl;
    }

    @PostMapping
    public ResponseEntity<NodeResource> createNode(@RequestBody CreateNodeResource resource) {
        try {
            var createNodeCommand = CreateNodeCommandFromResourceAssembler.toCommandFromResource(resource);
            var nodeId = nodeCommandServiceImpl.createNode(createNodeCommand);
            if (nodeId == 0L) {
                return ResponseEntity.badRequest().build();
            }
            var getNodeByIdQuery = new GetNodeByIdQuery(nodeId);
            var node = nodeQueryServiceImpl.findNodeById(getNodeByIdQuery);

            if (node.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }

            var nodeResource = NodeResourceFromEntityAssembler.toResourceFromEntity(node.get());
            return new ResponseEntity<>(nodeResource, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{nodeId}")
    public ResponseEntity<NodeResource> getNodeById(@PathVariable Long nodeId) {
        var getNodeByIdQuery = new GetNodeByIdQuery(nodeId);
        var node = nodeQueryServiceImpl.findNodeById(getNodeByIdQuery);
        if (node.isEmpty()) return ResponseEntity.badRequest().build();
        var nodeResource = NodeResourceFromEntityAssembler.toResourceFromEntity(node.get());
        return ResponseEntity.ok(nodeResource);
    }

    @GetMapping
    public ResponseEntity<List<NodeResource>> getNodes() {
        var listNodes = nodeQueryServiceImpl.findAllNodes();
        List<NodeResource> nodeResources = listNodes.stream()
                .map(NodeResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(nodeResources);
    }
    @GetMapping("/plot/{plotId}")
    public ResponseEntity<NodeResource> getNodeByPlotId(@PathVariable Long plotId) {
        var getNodeByPlotIdQuery = new GetNodeByPlotIdQuery(plotId);
        var node = nodeQueryServiceImpl.findNodeByPlotId(getNodeByPlotIdQuery);
        if (node.isEmpty()) return ResponseEntity.badRequest().build();
        var nodeResource = NodeResourceFromEntityAssembler.toResourceFromEntity(node.get());
        return ResponseEntity.ok(nodeResource);
    }
    @PutMapping("/{nodeId}/moisture")
    public ResponseEntity<Void> updateNodeMoisture(@PathVariable Long nodeId, @RequestBody UpdateNodeMoistureResource resource) {
        try {
            var updateNodeMoistureCommand = UpdateNodeMoistureCommandFromResourceAssembler.toCommand(nodeId, resource);
            nodeCommandServiceImpl.updateNodeMoisture(updateNodeMoistureCommand);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
