package com.example.simplevotingapi.repository;

import com.example.simplevotingapi.entity.VoteRoundEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRoundEntityRepository extends JpaRepository<VoteRoundEntity, Long> {

}
