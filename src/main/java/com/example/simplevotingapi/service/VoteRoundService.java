package com.example.simplevotingapi.service;

import com.example.simplevotingapi.dto.VoteRound;
import com.example.simplevotingapi.dto.VoteRoundToVoteRoundEntityMapper;
import com.example.simplevotingapi.entity.VoteRoundEntityToVoteRoundMapper;
import com.example.simplevotingapi.repository.VoteRoundEntityRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteRoundService {

    private final VoteRoundEntityRepository entityRepository;

    private final VoteRoundEntityToVoteRoundMapper entityToVoteRoundMapper;
    private final VoteRoundToVoteRoundEntityMapper voteRoundToEntityMapper;

    public List<VoteRound> getAllVoteRounds() {
        return entityToVoteRoundMapper.convert(entityRepository.findAll());
    }

    public VoteRound getVoteRoundById(Long id) {
        return entityToVoteRoundMapper.convert(entityRepository.findById(id)
                                                               .orElseThrow());
    }

    public VoteRound addVoteRound(VoteRound voteRound) {
        return entityToVoteRoundMapper.convert(entityRepository.save(voteRoundToEntityMapper.convert(voteRound)));
    }
}
