package com.example.simplevotingapi.dto;

import io.github.linpeilie.annotations.Immutable;
import lombok.Builder;

@Builder
@Immutable
public record Candidate(
    User user,
    Long numberOfVotes,
    Vote vote
) {

}
