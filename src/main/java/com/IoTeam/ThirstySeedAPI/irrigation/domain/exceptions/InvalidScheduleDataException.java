package com.IoTeam.ThirstySeedAPI.irrigation.domain.exceptions;

public class InvalidScheduleDataException extends RuntimeException {
    public InvalidScheduleDataException(String message) {
        super("Datos inválidos para el Schedule: " + message);
    }
}
