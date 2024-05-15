package com.example.simplevotingapi.dto;

import io.github.linpeilie.annotations.Immutable;
import java.time.ZonedDateTime;

@Immutable
public record Vote(
    User user,
    Candidate candidate,
    VoteRound votingRound,
    ZonedDateTime votedDateTime
) {

}