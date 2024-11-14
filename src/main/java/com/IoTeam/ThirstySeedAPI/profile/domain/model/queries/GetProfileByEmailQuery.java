package com.IoTeam.ThirstySeedAPI.profile.domain.model.queries;

import com.IoTeam.ThirstySeedAPI.profile.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}
