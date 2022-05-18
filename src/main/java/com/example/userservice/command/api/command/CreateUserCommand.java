package com.example.userservice.command.api.command;

import com.example.userservice.command.api.RequestRestTemplate.CardDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class CreateUserCommand {

    @TargetAggregateIdentifier
    private String userId;
    private String name;
    private String cardNumber;
    private String cardHolderName;
    private String validThrough;
    private String validUpto;
    private int cvv;
}