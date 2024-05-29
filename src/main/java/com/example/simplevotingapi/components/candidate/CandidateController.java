package com.example.simplevotingapi.components.candidate;

import com.example.simplevotingapi.components.candidate.output.Candidate;
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
public class CandidateController {

    private final CandidateService candidateService;

    @GetMapping(value = "/candidates", produces = "application/json")
    public ResponseEntity<List<Candidate>> getAllCandidate() {
        return new ResponseEntity<>(candidateService.getAllCandidates(),
                                    HttpStatus.OK);
    }

    @PostMapping(value = "/candidate", produces = "application/json")
    public ResponseEntity<Candidate> addCandidate(Candidate candidate) {
        return new ResponseEntity<>(candidateService.addCandidate(candidate),
                                    HttpStatus.OK);
    }

    @GetMapping(value = "/candidate/{id}", produces = "application/json")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(candidateService.getCandidateById(id),
                                    HttpStatus.OK);
    }
}
