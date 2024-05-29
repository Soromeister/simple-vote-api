package com.example.simplevotingapi.components.vote;

import com.example.simplevotingapi.components.candidate.CandidateEntity;
import com.example.simplevotingapi.components.user.UserEntity;
import com.example.simplevotingapi.components.vote.output.Vote;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMapping;
import io.github.linpeilie.annotations.AutoMappings;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Votes")
@AutoMapper(target = Vote.class, cycleAvoiding = true)
public class VoteEntity implements Serializable {

    @Getter
    @Setter
    @Builder
    @Embeddable
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VoteEntityId implements Serializable {

        @ManyToOne(optional = false)
        @JoinColumn(name = "user_id", nullable = false)
        private UserEntity user;

        @ManyToOne(optional = false)
        @JoinColumn(name = "candidate_id", nullable = false)
        private CandidateEntity candidate;

        @ManyToOne(optional = false)
        @JoinColumn(name = "round_id", nullable = false)
        private VoteRoundEntity votingRound;
    }

    @EmbeddedId
    @AutoMappings({@AutoMapping(source = "id.user", target = "user"),
                   @AutoMapping(source = "id.candidate", target = "candidate"),
                   @AutoMapping(source = "id.votingRound", target = "votingRound")})
    private VoteEntityId id;

    @Column(name = "vote_timestamp")
    protected ZonedDateTime votedDateTime;
}
