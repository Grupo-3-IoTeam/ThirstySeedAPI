package com.IoTeam.ThirstySeedAPI.irrigation.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.NonNull;


@Embeddable

public record ImageUrl(
        @NonNull @Column(name = "imageUrl") String imageUrl
) {
    public ImageUrl() {
        this(null);
    }


}