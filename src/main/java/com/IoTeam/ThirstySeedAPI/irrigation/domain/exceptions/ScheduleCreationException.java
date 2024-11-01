package com.IoTeam.ThirstySeedAPI.irrigation.domain.exceptions;

public class ScheduleCreationException extends RuntimeException {
    public ScheduleCreationException(String message) {
        super("Error al crear el Schedule: " + message);
    }
}
