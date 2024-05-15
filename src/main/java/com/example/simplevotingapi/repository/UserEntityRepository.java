package com.example.simplevotingapi.repository;

import com.example.simplevotingapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

}
