package com.example.simplevotingapi.components.vote;

import com.example.simplevotingapi.components.vote.output.VoteRound;
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
public class VoteRoundController {

    private final VoteRoundService voteRoundService;

    @GetMapping(value = "/vote-rounds", produces = "application/json")
    public ResponseEntity<List<VoteRound>> getAllVoteRounds() {
        return new ResponseEntity<>(voteRoundService.getAllVoteRounds(),
                                    HttpStatus.OK);
    }

    @PostMapping(value = "/vote-round", produces = "application/json")
    public ResponseEntity<VoteRound> addVoteRound(VoteRound voteRound) {
        return new ResponseEntity<>(voteRoundService.addVoteRound(voteRound),
                                    HttpStatus.OK);
    }

    @GetMapping(value = "/vote-round/{id}", produces = "application/json")
    public ResponseEntity<VoteRound> getVoteRoundById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(voteRoundService.getVoteRoundById(id),
                                    HttpStatus.OK);
    }
}
