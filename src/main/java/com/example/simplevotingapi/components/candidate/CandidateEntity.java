package com.example.simplevotingapi.components.candidate;

import com.example.simplevotingapi.components.candidate.output.Candidate;
import com.example.simplevotingapi.components.user.UserEntity;
import com.example.simplevotingapi.components.vote.VoteEntity;
import io.github.linpeilie.annotations.AutoMapper;
import io.github.linpeilie.annotations.AutoMapping;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Candidates")
@AutoMapper(target = Candidate.class, cycleAvoiding = true)
public class CandidateEntity implements Serializable {

    @MapsId
    @OneToOne
    @AutoMapping(source = "userId", target = "user")
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private UserEntity userId;

    @Id
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    public ZonedDateTime createdDate;

    @Column(name = "counter")
    private Long numberOfVotes;

    @OneToOne(mappedBy = "id.candidate")
    private VoteEntity vote;
}
