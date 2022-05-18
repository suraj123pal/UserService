package com.example.userservice.command.api.events;

import com.example.userservice.command.api.entity.CardEntity;
import com.example.userservice.command.api.entity.UserEntity;
import com.example.userservice.command.api.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserEventHandler {

    private UserRepo userRepo;

    public UserEventHandler(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @EventHandler
    public void handle(UserCreatedEvent userCreatedEvent)
    {
        CardEntity cardEntity = new CardEntity();

        UserEntity userEntity = UserEntity.builder()
                .userId(userCreatedEvent.getUserId())
                .name(userCreatedEvent.getName())
                .cardEntity(CardEntity.
                        builder()
                        .cardHolderName(userCreatedEvent.getCardHolderName())
                        .cardNumber(userCreatedEvent.getCardNumber())
                        .cvv(userCreatedEvent.getCvv())
                        .validThrough(userCreatedEvent.getValidThrough())
                        .validUpto(userCreatedEvent.getValidUpto())
                        .build())
                .build();

        userRepo.save(userEntity);
        log.info("user created "+ userEntity.toString());

    }
}