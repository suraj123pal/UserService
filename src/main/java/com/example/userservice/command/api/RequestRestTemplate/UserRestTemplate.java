package com.example.userservice.command.api.RequestRestTemplate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRestTemplate {

    private String name;
    private CardDetails cardDetails;
}