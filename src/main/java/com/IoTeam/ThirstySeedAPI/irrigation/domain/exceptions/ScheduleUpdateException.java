package com.IoTeam.ThirstySeedAPI.irrigation.domain.exceptions;

public class ScheduleUpdateException extends RuntimeException {
    public ScheduleUpdateException(String message) {
        super("Error al actualizar el Schedule: " + message);
    }
}
