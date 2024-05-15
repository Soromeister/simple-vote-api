package com.example.simplevotingapi.dto;

import io.github.linpeilie.annotations.Immutable;
import java.time.ZonedDateTime;
import java.util.HashSet;

@Immutable
public record VoteRound(
    Long id,
    ZonedDateTime createdDate,
    ZonedDateTime updatedDate,
    ZonedDateTime startDate,
    ZonedDateTime endDate,
    HashSet<Vote> votes
) {

}
