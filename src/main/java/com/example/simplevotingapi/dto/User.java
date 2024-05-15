package com.example.simplevotingapi.dto;

import io.github.linpeilie.annotations.Immutable;
import java.time.ZonedDateTime;
import java.util.HashSet;

@Immutable
public record User(
    Long id,
    ZonedDateTime createdDate,
    ZonedDateTime updatedDate,
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
    HashSet<Vote> votes
) {

}
