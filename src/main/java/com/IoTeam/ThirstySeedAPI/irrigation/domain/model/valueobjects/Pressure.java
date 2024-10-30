package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects;

public record Pressure(double value, String unit) {
    public Pressure {
        if (value <= 0) {
            throw new IllegalArgumentException("La presión debe ser mayor a cero.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pressure pressure = (Pressure) o;
        return Double.compare(pressure.value, value) == 0 && unit.equals(pressure.unit);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}
