package com.example.simplevotingapi.dto;

import io.github.linpeilie.annotations.Immutable;
import java.time.ZonedDateTime;
import lombok.Builder;

@Builder
@Immutable
public record Candidate(
    User user,
    ZonedDateTime createdDate,
    Vote vote
) {

}
