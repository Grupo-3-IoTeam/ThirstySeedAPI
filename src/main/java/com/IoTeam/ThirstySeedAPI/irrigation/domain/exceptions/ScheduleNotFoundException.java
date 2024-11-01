package com.IoTeam.ThirstySeedAPI.irrigation.domain.exceptions;

public class ScheduleNotFoundException extends RuntimeException {
    public ScheduleNotFoundException(Long scheduleId) {
        super("No se encontró el Schedule con ID: " + scheduleId);
    }
}
