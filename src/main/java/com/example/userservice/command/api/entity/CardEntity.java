package com.example.userservice.command.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CardEntity {
    private String cardNumber;
    private String cardHolderName;
    private String validThrough;
    private String validUpto;
    private int cvv;
}