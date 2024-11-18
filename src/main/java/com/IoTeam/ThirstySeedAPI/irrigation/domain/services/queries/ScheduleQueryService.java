package com.IoTeam.ThirstySeedAPI.irrigation.domain.services.queries;

import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.aggregates.Schedule;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetAllSchedulesQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetScheduleByIdQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetSchedulesByPlotIdQuery;
import com.IoTeam.ThirstySeedAPI.irrigation.domain.model.queries.GetSchedulesByUserIdQuery;


import java.util.List;
import java.util.Optional;

public interface ScheduleQueryService {
    Optional<Schedule> handle(GetScheduleByIdQuery query);
    List<Schedule> handle(GetAllSchedulesQuery query);
    List<Schedule> handle(GetSchedulesByPlotIdQuery query);
    List<Schedule> handle(GetSchedulesByUserIdQuery query);
}
