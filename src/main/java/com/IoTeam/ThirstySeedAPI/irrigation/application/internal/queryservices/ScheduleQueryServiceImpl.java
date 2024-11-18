package com.IoTeam.ThirstySeedAPI.irrigation.application.internal.queryservices;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Plot;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Schedule;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetAllSchedulesQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetScheduleByIdQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetSchedulesByPlotIdQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetSchedulesByUserIdQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.services.queries.ScheduleQueryService;
import com.IoTeam.ThirstySeedAPI.irrigation.infrastructure.persistence.jpa.repositories.PlotRepository;
import com.IoTeam.ThirstySeedAPI.irrigation.infrastructure.persistence.jpa.repositories.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleQueryServiceImpl implements ScheduleQueryService {

    private final ScheduleRepository scheduleRepository;
    private final PlotRepository plotRepository;

    public ScheduleQueryServiceImpl(ScheduleRepository scheduleRepository, PlotRepository plotRepository) {
        this.scheduleRepository = scheduleRepository;
        this.plotRepository = plotRepository;
    }

    @Override
    public Optional<Schedule> handle(GetScheduleByIdQuery query) {
        return scheduleRepository.findById(query.scheduleId());
    }

    @Override
    public List<Schedule> handle(GetAllSchedulesQuery query) {
        return scheduleRepository.findAll();
    }

    @Override
    public List<Schedule> handle(GetSchedulesByPlotIdQuery query) {
        Long plotId = query.plotId();
        return scheduleRepository.findByPlotId(plotId);
    }

    @Override
    public List<Schedule> handle(GetSchedulesByUserIdQuery query) {
        // Primero obtener los plotIds del usuario especificado y luego buscar los horarios
        Long userId = query.userId();
        List<Plot> userPlots = plotRepository.findByUserId(userId);

        if (userPlots.isEmpty()) {
            return List.of();
        }

        // Obtener los IDs de los plots del usuario
        List<Long> plotIds = userPlots.stream()
                .map(Plot::getId)
                .collect(Collectors.toList());

        // Obtener todos los horarios que correspondan a esos plotIds
        return scheduleRepository.findByPlotIdIn(plotIds);
    }
}