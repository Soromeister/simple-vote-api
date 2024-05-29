package com.example.simplevotingapi.components.candidate.output;

import com.example.simplevotingapi.components.user.output.User;
import com.example.simplevotingapi.components.vote.output.Vote;
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
