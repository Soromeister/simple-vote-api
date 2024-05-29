package com.example.simplevotingapi.components.candidate;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateEntityRepository extends JpaRepository<CandidateEntity, Long>, JpaSpecificationExecutor<CandidateEntity> {

    @NonNull
    @Override
    @Query("select c from CandidateEntity c where c.userId.id = ?1")
    Optional<CandidateEntity> findById(@NonNull Long id);

}
