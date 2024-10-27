package com.IoTeam.ThirstySeedAPI.datamanagement.plot.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum PlotStatus {
    REQUESTED,
    SUPPLIED,
    NOT_SUPPLIED
}
