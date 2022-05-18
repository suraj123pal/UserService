package com.example.userservice.command.api.entity;

import com.example.userservice.command.api.RequestRestTemplate.CardDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    @Id
    private String userId;
    private String name;
    @Embedded
    private CardEntity cardEntity;
}