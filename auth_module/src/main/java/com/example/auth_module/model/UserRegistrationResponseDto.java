package com.example.auth_module.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class UserRegistrationResponseDto {

    private String message;
    private String login;
    private LocalDateTime registrationDate;
}
