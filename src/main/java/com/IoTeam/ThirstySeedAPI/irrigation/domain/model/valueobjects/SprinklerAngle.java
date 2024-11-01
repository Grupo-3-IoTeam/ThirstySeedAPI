package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects;

public record SprinklerAngle(int angle) {
    public SprinklerAngle {
        if (angle < 0 || angle > 360) {
            throw new IllegalArgumentException("El ángulo debe estar entre 0 y 360 grados.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SprinklerAngle that = (SprinklerAngle) o;
        return angle == that.angle;
    }

    @Override
    public String toString() {
        return angle + " grados";
    }
}
