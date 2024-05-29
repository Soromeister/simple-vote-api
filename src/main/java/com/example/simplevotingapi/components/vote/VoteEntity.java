package com.example.simplevotingapi.components.vote;

import com.example.simplevotingapi.components.vote.output.Vote;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMapping;
import io.github.linpeilie.annotations.AutoMappings;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
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

    @EmbeddedId
    @AutoMappings({@AutoMapping(source = "id.user", target = "user"),
                   @AutoMapping(source = "id.candidate", target = "candidate"),
                   @AutoMapping(source = "id.votingRound", target = "votingRound")})
    private VoteEntityId id;

    @Column(name = "vote_timestamp")
    protected ZonedDateTime votedDateTime;
}
