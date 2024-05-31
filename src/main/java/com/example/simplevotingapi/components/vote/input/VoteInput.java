package com.example.simplevotingapi.components.vote.input;

import io.github.linpeilie.annotations.Immutable;
import lombok.Builder;

@Builder
@Immutable
public record VoteInput(Long userId,
                        Long candidateId,
                        Long votingRoundId) {

}
