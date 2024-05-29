package com.example.simplevotingapi.service;

import com.example.simplevotingapi.dto.Vote;
import com.example.simplevotingapi.dto.VoteToVoteEntityMapper;
import com.example.simplevotingapi.entity.VoteEntityToVoteMapper;
import com.example.simplevotingapi.repository.VoteEntityRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteEntityRepository entityRepository;

    private final VoteEntityToVoteMapper entityToVoteMapper;
    private final VoteToVoteEntityMapper voteToEntityMapper;

    public List<Vote> getAllVotes() {
        return entityToVoteMapper.convert(entityRepository.findAll());
    }

    public Vote getVoteById(Long userId,
                            Long candidateId,
                            Long votingRoundId) {
        return entityToVoteMapper.convert(entityRepository.findById(userId,
                                                                    candidateId,
                                                                    votingRoundId)
                                                          .orElseThrow());
    }

    public Vote addVote(Vote vote) {
        return entityToVoteMapper.convert(entityRepository.save(voteToEntityMapper.convert(vote)));
    }
}
