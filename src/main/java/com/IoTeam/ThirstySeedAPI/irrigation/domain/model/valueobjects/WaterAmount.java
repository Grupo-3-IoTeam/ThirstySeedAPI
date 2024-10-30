package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects;

import lombok.Getter;

@Getter
public record WaterAmount(double amount, String unit) {
    public WaterAmount {
        if (amount <= 0) {
            throw new IllegalArgumentException("La cantidad de agua debe ser mayor a cero.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaterAmount that = (WaterAmount) o;
        return Double.compare(that.amount, amount) == 0 && unit.equals(that.unit);
    }

    @Override
    public String toString() {
        return amount + " " + unit;
    }
}
