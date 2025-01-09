package com.example.auth_module.controller;

import com.example.auth_module.model.UserAuthorizationRequestDto;
import com.example.auth_module.model.UserRegistrationRequestDto;
import com.example.auth_module.model.UserRegistrationResponseDto;
import com.example.auth_module.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.auth_module.constant.Constants.USER_AUTHORIZATION_URL;
import static com.example.auth_module.constant.Constants.USER_REGISTRATION_URL;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(USER_REGISTRATION_URL)
    public UserRegistrationResponseDto userRegistration(@RequestBody UserRegistrationRequestDto user) {
        return authService.userRegistration(user);
    }

    @PostMapping(USER_AUTHORIZATION_URL)
    public String userAuthorization(@RequestBody UserAuthorizationRequestDto user) {
        return authService.userAuthorization(user);
    }

}
