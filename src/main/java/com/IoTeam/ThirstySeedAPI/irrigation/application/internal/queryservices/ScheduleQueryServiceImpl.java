package com.IoTeam.ThirstySeedAPI.irrigation.application.internal.queryservices;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Schedule;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetAllSchedulesQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetScheduleByIdQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.services.queries.ScheduleQueryService;
import com.IoTeam.ThirstySeedAPI.irrigation.infrastructure.persistence.jpa.repositories.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleQueryServiceImpl implements ScheduleQueryService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleQueryServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Optional<Schedule> handle(GetScheduleByIdQuery query) {
        return scheduleRepository.findById(query.scheduleId());
    }

    @Override
    public List<Schedule> handle(GetAllSchedulesQuery query) {
        return scheduleRepository.findAll();
    }
}
