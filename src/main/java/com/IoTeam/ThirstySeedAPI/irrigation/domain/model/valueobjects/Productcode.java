package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Productcode(String productcode) {
    public Productcode(){
        this(null);
    }

    public Productcode {
        if (productcode == null || productcode.isBlank()) {
            throw new IllegalArgumentException("Product Code cannot be null or blank");
        }

    }


}
