package com.example.userservice.command.api.repository;

import com.example.userservice.command.api.RequestRestTemplate.UserRestTemplate;
import com.example.userservice.command.api.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Long> {
}