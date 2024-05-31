package com.example.simplevotingapi.components.vote;

import com.example.simplevotingapi.components.vote.input.VoteInput;
import com.example.simplevotingapi.components.vote.output.Vote;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @GetMapping(value = "/votes", produces = "application/json")
    public ResponseEntity<List<Vote>> getAllVotes() {
        return new ResponseEntity<>(voteService.getAllVotes(),
                                    HttpStatus.OK);
    }

    @PostMapping(value = "/vote", produces = "application/json")
    public ResponseEntity<Vote> addVote(VoteInput vote) {
        return new ResponseEntity<>(voteService.addVote(vote),
                                    HttpStatus.OK);
    }

    @GetMapping(value = "/vote/{userId}_{candidateId}_{votingRoundId}", produces = "application/json")
    public ResponseEntity<Vote> getVoteById(@PathVariable("userId") Long userId,
                                            @PathVariable("candidateId") Long candidateId,
                                            @PathVariable("votingRoundId") Long votingRoundId) {
        return new ResponseEntity<>(voteService.getVoteById(userId,
                                                            candidateId,
                                                            votingRoundId),
                                    HttpStatus.OK);
    }
}
