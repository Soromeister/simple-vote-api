package com.example.simplevotingapi.components.vote;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class VoteRoundController {

    private final VoteRoundService voteRoundService;
}
