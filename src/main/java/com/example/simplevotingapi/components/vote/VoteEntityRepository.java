package com.example.simplevotingapi.components.vote;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VoteEntityRepository extends JpaRepository<VoteEntity, VoteEntityId> {

    @Query("select v from VoteEntity v where v.id.user.id = ?1 and v.id.candidate.id = ?2 and v.id.votingRound.id = ?3")
    Optional<VoteEntity> findById(Long userId,
                                  Long candidateId,
                                  Long votingRoundId);
}
