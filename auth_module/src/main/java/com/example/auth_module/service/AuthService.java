package com.example.auth_module.service;

import com.example.auth_module.model.UserAuthorizationRequestDto;
import com.example.auth_module.model.UserRegistrationRequestDto;
import com.example.auth_module.model.UserRegistrationResponseDto;

public interface AuthService {

    UserRegistrationResponseDto userRegistration(UserRegistrationRequestDto user);
    String userAuthorization(UserAuthorizationRequestDto user);
}
