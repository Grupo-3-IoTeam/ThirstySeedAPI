package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects;

public record WaterAmount(double waterAmount) {
    public WaterAmount {
        if (waterAmount <= 0) {
            throw new IllegalArgumentException("La cantidad de agua debe ser mayor a cero.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaterAmount that = (WaterAmount) o;
        return Double.compare(that.waterAmount, waterAmount) == 0;
    }

    @Override
    public String toString() {
        return waterAmount + " L";
    }
}
