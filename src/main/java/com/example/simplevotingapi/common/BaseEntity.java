package com.example.simplevotingapi.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.io.Serializable;
import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @Min(100)
    @Column(name = "id")
    @Max(Integer.MAX_VALUE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @JsonSerialize
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    public ZonedDateTime createdDate;

    @JsonSerialize
    @UpdateTimestamp
    @Column(name = "updated_at")
    public ZonedDateTime updatedDate;
}
