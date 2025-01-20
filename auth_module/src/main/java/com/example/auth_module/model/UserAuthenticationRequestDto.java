package com.example.auth_module.model;

import lombok.Data;

@Data
public class UserAuthenticationRequestDto {

    private String login;
    private String password;

}
