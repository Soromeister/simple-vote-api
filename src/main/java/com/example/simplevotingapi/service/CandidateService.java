package com.example.simplevotingapi.service;

import com.example.simplevotingapi.dto.Candidate;
import com.example.simplevotingapi.dto.CandidateToCandidateEntityMapper;
import com.example.simplevotingapi.entity.CandidateEntityToCandidateMapper;
import com.example.simplevotingapi.repository.CandidateEntityRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateEntityRepository entityRepository;

    private final CandidateEntityToCandidateMapper entityToCandidateMapper;
    private final CandidateToCandidateEntityMapper candidateToEntityMapper;

    public List<Candidate> getAllCandidates() {
        return entityToCandidateMapper.convert(entityRepository.findAll());
    }

    public Candidate getCandidateById(Long id) {
        return entityToCandidateMapper.convert(entityRepository.findById(id)
                                                                                 .orElseThrow());
    }
    public Candidate addCandidate(Candidate candidate) {
        return entityToCandidateMapper.convert(entityRepository.save(candidateToEntityMapper.convert(candidate)));
    }
}
