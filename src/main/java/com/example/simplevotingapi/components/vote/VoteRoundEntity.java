package com.example.simplevotingapi.components.vote;

import com.example.simplevotingapi.components.common.BaseEntity;
import com.example.simplevotingapi.components.vote.output.VoteRound;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMapping;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Set;
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
@Table(name = "Voting_Rounds")
@AutoMapper(target = VoteRound.class, cycleAvoiding = true)
public class VoteRoundEntity extends BaseEntity implements Serializable {

    @Column(name = "start_date")
    @AutoMapping(target = "startDate")
    private ZonedDateTime start;

    @Column(name = "end_date")
    @AutoMapping(target = "endDate")
    private ZonedDateTime end;

    @OneToMany(mappedBy = "id.votingRound")
    private Set<VoteEntity> votes;
}
