package com.IoTeam.ThirstySeedAPI.irrigation.domain.exceptions;

public class ScheduleDeletionException extends RuntimeException {
    public ScheduleDeletionException(Long scheduleId) {
        super("Error al eliminar el Schedule con ID: " + scheduleId);
    }
}
