package com.example.userservice.command.api.RequestRestTemplate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CardDetails {

    private String cardNumber;
    private String cardHolderName;
    private String validThrough;
    private String validUpto;
    private int cvv;
}