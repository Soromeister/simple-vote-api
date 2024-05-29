package com.example.simplevotingapi.components.vote.output;

import io.github.linpeilie.annotations.Immutable;
import java.time.ZonedDateTime;
import java.util.Set;
import lombok.Builder;

@Builder
@Immutable
public record VoteRound(
    Long id,
    ZonedDateTime startDate,
    ZonedDateTime endDate,
    Set<Vote> votes
) {

}
