package com.example.auth_module.model;

import lombok.Data;

@Data
public class UserRegistrationRequestDto {

    private String login;
    private String password;
    private String email;

}
