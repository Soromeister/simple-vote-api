package com.example.simplevotingapi.components.user.output;

import com.example.simplevotingapi.components.candidate.output.Candidate;
import com.example.simplevotingapi.components.vote.output.Vote;
import io.github.linpeilie.annotations.Immutable;
import java.util.Set;
import lombok.Builder;

@Builder
@Immutable
public record User(
    Long id,
    String password,
    String username,
    String lastName,
    String firstName,
    String address,
    String description,
    String city,
    String state,
    String zip,
    String linkPhoto,
    String role,
    Candidate candidate,
    Set<Vote> votes
) {

}
