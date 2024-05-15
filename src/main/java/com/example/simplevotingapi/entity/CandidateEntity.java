package com.example.simplevotingapi.entity;

import com.example.simplevotingapi.dto.Candidate;
import io.github.linpeilie.annotations.AutoMapper;
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

    @Id
    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private UserEntity user;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    public ZonedDateTime createdDate;

    @OneToOne(mappedBy = "id.candidate")
    private VoteEntity vote;
}
