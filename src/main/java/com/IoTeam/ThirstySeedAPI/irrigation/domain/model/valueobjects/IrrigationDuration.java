package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects;

public record IrrigationDuration(int hours) {
    public IrrigationDuration {
        if (hours <= 0) {
            throw new IllegalArgumentException("La duración debe ser positiva.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IrrigationDuration that = (IrrigationDuration) o;
        return hours == that.hours;
    }

    @Override
    public String toString() {
        return hours + " horas";
    }
}
