package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects;

public record Pressure(double pressureValue) {
    public Pressure {
        if (pressureValue <= 0) {
            throw new IllegalArgumentException("La presión debe ser mayor a cero.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pressure pressure = (Pressure) o;
        return Double.compare(pressure.pressureValue, pressureValue) == 0;
    }

    @Override
    public String toString() {
        return pressureValue + " PSI";
    }
}
