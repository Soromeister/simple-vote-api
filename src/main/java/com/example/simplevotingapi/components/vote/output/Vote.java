package com.example.simplevotingapi.components.vote.output;

import com.example.simplevotingapi.components.candidate.output.Candidate;
import com.example.simplevotingapi.components.user.output.User;
import io.github.linpeilie.annotations.Immutable;
import java.time.ZonedDateTime;
import lombok.Builder;

@Builder
@Immutable
public record Vote(
    User user,
    Candidate candidate,
    VoteRound votingRound,
    ZonedDateTime votedDateTime
) {

}
