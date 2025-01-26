package com.example.auth_module.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserRegistrationRequestDto {

    private String login;
    private String password;
    private String email;
    private LocalDateTime birthDate;
    private boolean foreignCitizen;
    private String cityFrom;
}
