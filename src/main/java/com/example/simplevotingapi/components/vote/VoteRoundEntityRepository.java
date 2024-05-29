package com.example.simplevotingapi.components.vote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VoteRoundEntityRepository extends JpaRepository<VoteRoundEntity, Long>, JpaSpecificationExecutor<VoteRoundEntity> {

}
