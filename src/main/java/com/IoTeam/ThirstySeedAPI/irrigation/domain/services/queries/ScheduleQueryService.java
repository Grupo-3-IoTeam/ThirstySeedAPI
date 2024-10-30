package com.IoTeam.ThirstySeedAPI.irrigation.domain.services.queries;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Schedule;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetAllSchedulesQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetScheduleByIdQuery;


import java.util.List;
import java.util.Optional;

public interface ScheduleQueryService {
    Optional<Schedule> findScheduleById(GetScheduleByIdQuery query);
    List<Schedule> findAllSchedules(GetAllSchedulesQuery query);
}
