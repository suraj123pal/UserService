package com.example.userservice.command.api.events;

import com.example.userservice.command.api.RequestRestTemplate.CardDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreatedEvent {

    private String userId;
    private String name;
    private String cardNumber;
    private String cardHolderName;
    private String validThrough;
    private String validUpto;
    private int cvv;
}