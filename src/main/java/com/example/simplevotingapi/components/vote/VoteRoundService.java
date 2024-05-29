package com.example.simplevotingapi.components.vote;

import com.example.simplevotingapi.components.vote.output.VoteRound;
import com.example.simplevotingapi.components.vote.output.VoteRoundToVoteRoundEntityMapper;
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
