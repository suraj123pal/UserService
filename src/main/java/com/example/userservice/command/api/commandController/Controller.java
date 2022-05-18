package com.example.userservice.command.api.commandController;

import com.example.userservice.command.api.RequestRestTemplate.CardDetails;
import com.example.userservice.command.api.RequestRestTemplate.UserRestTemplate;
import com.example.userservice.command.api.command.CreateUserCommand;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class Controller {

    private CommandGateway commandGateway;

    public Controller(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/")
    public String createUser(@RequestBody UserRestTemplate userRestTemplate)
    {


        CreateUserCommand createUserCommand =
                CreateUserCommand.builder()
                        .userId(UUID.randomUUID().toString())
                        .name(userRestTemplate.getName())
                        .cardHolderName(userRestTemplate.getCardDetails().getCardHolderName())
                        .cardNumber(userRestTemplate.getCardDetails().getCardNumber())
                        .cvv(userRestTemplate.getCardDetails().getCvv())
                        .validThrough(userRestTemplate.getCardDetails().getValidThrough())
                        .validUpto(userRestTemplate.getCardDetails().getValidUpto())
                        .build();
        log.info(createUserCommand.toString());
        commandGateway.sendAndWait(createUserCommand);
        log.info("user details in controller level...." + createUserCommand.toString());
        return createUserCommand.getUserId();
    }
}