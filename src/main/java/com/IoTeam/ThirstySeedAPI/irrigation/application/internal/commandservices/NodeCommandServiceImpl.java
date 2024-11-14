package com.IoTeam.ThirstySeedAPI.irrigation.application.internal.commandservices;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Node;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.CreateNodeCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.DeleteNodeCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.UpdateNodeCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.commands.UpdateNodeMoistureCommand;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects.*;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.services.commands.NodeCommandService;
import com.IoTeam.ThirstySeedAPI.irrigation.infrastructure.persistence.jpa.repositories.NodeRepository;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Plot;
import com.IoTeam.ThirstySeedAPI.irrigation.infrastructure.persistence.jpa.repositories.PlotRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NodeCommandServiceImpl implements NodeCommandService {

    private final NodeRepository nodeRepository;
    private final PlotRepository plotRepository;

    public NodeCommandServiceImpl(NodeRepository nodeRepository, PlotRepository plotRepository) {
        this.nodeRepository = nodeRepository;
        this.plotRepository = plotRepository;
    }

    @Override
    public Long createNode(CreateNodeCommand command) {
        Optional<Plot> optionalPlot = plotRepository.findById(command.plotId());
        if (optionalPlot.isEmpty()) {
            throw new IllegalArgumentException("Plot with ID " + command.plotId() + " does not exist.");
        }

        Plot plot = optionalPlot.get();
        String status = command.moisture() > 20 ? "Correct" : "Error";
        String statusClass = status.equals("Correct") ? "status-correct" : "status-error";
        String iconClass = status.equals("Correct") ? "pi pi-check" : "pi pi-exclamation-triangle";

        Node node = new Node(
                plot,
                new NodeLocation(command.nodelocation()),
                new Moisture(command.moisture()),
                new Indicator(command.indicator()),
                new Status(status),
                new StatusClass(statusClass),
                new IconClass(iconClass),
                new IsActive(command.isActive()),
                new Productcode(command.productcode())
        );

        nodeRepository.save(node);
        return node.getId();
    }
    @Override
    public void updateNodeMoisture(UpdateNodeMoistureCommand command) {
        var nodemoistureOptional = nodeRepository.findById(command.nodeId());
        if (nodemoistureOptional.isEmpty()) {
            throw new IllegalArgumentException("Node with ID " + command.nodeId() + " does not exist.");
        }
        Node node = nodemoistureOptional.get();
        node.setMoisture(new Moisture(command.moisture()));
        nodeRepository.save(node);
    }
    @Override
    public void updateNode(UpdateNodeCommand command) {
        var nodeOptional = nodeRepository.findById(command.nodeId());
        if (nodeOptional.isEmpty()) {
            throw new IllegalArgumentException("Node with ID " + command.nodeId() + " does not exist.");
        }

        Node node = nodeOptional.get();
        node.setNodelocation(new NodeLocation(command.nodelocation()));


        nodeRepository.save(node);
    }
    @Override
    public void deleteNode(DeleteNodeCommand command) {
        if (!nodeRepository.existsById(command.nodeId())) {
            throw new IllegalArgumentException("Node with ID " + command.nodeId() + " does not exist.");
        }
        nodeRepository.deleteById(command.nodeId());
    }
}
