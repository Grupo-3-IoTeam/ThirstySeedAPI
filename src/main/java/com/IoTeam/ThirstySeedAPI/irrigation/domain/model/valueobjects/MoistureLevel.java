package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects;

public record MoistureLevel(double level) {
    public MoistureLevel {
        if (level < 0 || level > 100) {
            throw new IllegalArgumentException("El nivel de humedad debe estar entre 0 y 100.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoistureLevel that = (MoistureLevel) o;
        return Double.compare(that.level, level) == 0;
    }

    @Override
    public String toString() {
        return level + "%";
    }
}
