package com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.model.valueobjects;


import jakarta.persistence.Embeddable;

@Embeddable
public record Extension(Integer extension) {

    public Extension() {
        this(0);
    }

    public Extension {
        if (extension == null || extension <= 0) {
            throw new IllegalArgumentException("Extension value must be more than zero");
        }
    }
}
