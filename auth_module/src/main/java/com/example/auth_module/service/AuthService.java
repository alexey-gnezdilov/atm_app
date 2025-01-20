package com.example.auth_module.service;

import com.example.auth_module.model.UserAuthenticationRequestDto;
import com.example.auth_module.model.UserRegistrationRequestDto;
import com.example.auth_module.model.UserRegistrationResponseDto;

public interface AuthService {

    UserRegistrationResponseDto userRegistration(UserRegistrationRequestDto user);
    String userAuthentication(UserAuthenticationRequestDto user);
}
