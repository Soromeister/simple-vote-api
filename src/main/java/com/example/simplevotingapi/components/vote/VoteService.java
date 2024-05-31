package com.example.simplevotingapi.components.vote;

import com.example.simplevotingapi.components.candidate.CandidateEntityRepository;
import com.example.simplevotingapi.components.user.UserEntityRepository;
import com.example.simplevotingapi.components.vote.input.VoteInput;
import com.example.simplevotingapi.components.vote.output.Vote;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteEntityRepository entityRepository;
    private final UserEntityRepository userEntityRepository;
    private final CandidateEntityRepository candidateEntityRepository;
    private final VoteRoundEntityRepository voteRoundEntityRepository;

    private final VoteEntityToVoteMapper entityToVoteMapper;

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

    public Vote addVote(VoteInput vote) {
        return entityToVoteMapper.convert(entityRepository.save(VoteEntity.builder()
                                                                          .id(VoteEntity.VoteEntityId.builder()
                                                                                                     .user(userEntityRepository.findById(vote.userId())
                                                                                                                               .orElseThrow())
                                                                                                     .candidate(candidateEntityRepository.findById(vote.candidateId())
                                                                                                                                         .orElseThrow())
                                                                                                     .votingRound(voteRoundEntityRepository.findById(vote.votingRoundId())
                                                                                                                                           .orElseThrow())
                                                                                                     .build())
                                                                          .build()));
    }
}
