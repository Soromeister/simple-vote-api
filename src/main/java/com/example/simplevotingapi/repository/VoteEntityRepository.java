package com.example.simplevotingapi.repository;

import com.example.simplevotingapi.entity.VoteEntity;
import com.example.simplevotingapi.entity.VoteEntityId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteEntityRepository extends JpaRepository<VoteEntity, VoteEntityId> {

}
