package com.example.userservice.command.api.aggregate;

import com.example.userservice.command.api.RequestRestTemplate.CardDetails;
import com.example.userservice.command.api.command.CreateUserCommand;
import com.example.userservice.command.api.events.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
@Slf4j
public class UserAggregate {

    @AggregateIdentifier
    private String userId;
    private String name;
    private String cardNumber;
    private String cardHolderName;
    private String validThrough;
    private String validUpto;
    private int cvv;

    public UserAggregate() {
    }

    @CommandHandler
    public UserAggregate(CreateUserCommand command) {

        UserCreatedEvent userCreatedEvent = new UserCreatedEvent();
        BeanUtils.copyProperties(command,userCreatedEvent);

        AggregateLifecycle.apply(userCreatedEvent);
    }

    @EventSourcingHandler
    public void on(UserCreatedEvent userCreatedEvent)
    {

        this.userId = userCreatedEvent.getUserId();
        this.name = userCreatedEvent.getName();
        this.cardHolderName = userCreatedEvent.getCardHolderName();
        this.cardNumber = userCreatedEvent.getCardNumber();
        this.cvv=userCreatedEvent.getCvv();
        this.validThrough= userCreatedEvent.getValidThrough();
        this.validUpto = userCreatedEvent.getValidUpto();
    }
}