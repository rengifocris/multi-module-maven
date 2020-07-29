package com.rengifo.domain.entity;

import lombok.ToString;
import lombok.Data;
import lombok.Builder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Data
@ToString
public class User {
    private String id;
    private String email;
    private String password;
    private String lastName;
    private String firstName;
}
