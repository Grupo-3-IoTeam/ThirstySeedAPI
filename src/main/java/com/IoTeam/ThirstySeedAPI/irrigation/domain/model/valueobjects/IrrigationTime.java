package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects;

public record IrrigationTime(String time) {
    private static final String TIME_PATTERN = "^(0[1-9]|1[0-2]):[0-5][0-9] (AM|PM)$";

    public IrrigationTime {
        if (time == null || time.isEmpty()) {
            throw new IllegalArgumentException("La hora de riego no puede estar vacía.");
        }
        if (!time.matches(TIME_PATTERN)) {
            throw new IllegalArgumentException("El formato de la hora debe ser 'hh:mm AM/PM'.");
        }
    }

    @Override
    public String toString() {
        return time;
    }
}