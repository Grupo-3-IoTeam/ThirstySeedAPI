package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects;

public record SprinklerRadius(double radius) {
    public SprinklerRadius {
        if (radius <= 0) {
            throw new IllegalArgumentException("El radio del aspersor debe ser mayor a cero.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SprinklerRadius that = (SprinklerRadius) o;
        return Double.compare(that.radius, radius) == 0;
    }

    @Override
    public String toString() {
        return radius + " m";
    }
}
