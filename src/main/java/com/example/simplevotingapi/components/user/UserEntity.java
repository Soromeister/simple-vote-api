package com.example.simplevotingapi.components.user;

import com.example.simplevotingapi.components.candidate.CandidateEntity;
import com.example.simplevotingapi.components.common.BaseEntity;
import com.example.simplevotingapi.components.user.output.User;
import com.example.simplevotingapi.components.vote.VoteEntity;
import io.github.linpeilie.annotations.AutoMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
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
@Table(name = "Users")
@AutoMapper(target = User.class, cycleAvoiding = true)
public class UserEntity extends BaseEntity implements Serializable {

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    @Column(name = "link_photo")
    private String linkPhoto;

    @Column(name = "role")
    private String role;

    @OneToOne(mappedBy = "userId")
    private CandidateEntity candidate;

    @OneToMany(mappedBy = "id.user")
    private Set<VoteEntity> votes;

}
