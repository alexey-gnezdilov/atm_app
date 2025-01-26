package com.example.auth_module.controller;

import com.example.auth_module.model.UserAuthenticationRequestDto;
import com.example.auth_module.model.UserRegistrationRequestDto;
import com.example.auth_module.model.UserRegistrationResponseDto;
import com.example.auth_module.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.example.auth_module.constant.Constants.*;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(USER_REGISTRATION_URL)
    public UserRegistrationResponseDto userRegistration(@RequestBody UserRegistrationRequestDto user) {
        return authService.userRegistration(user);
    }

    @PostMapping(USER_AUTHENTICATION_URL)
    public String userAuthentication(@RequestBody UserAuthenticationRequestDto user) {
        return authService.userAuthentication(user);
    }

    @GetMapping(CONFIRMATION_OF_REGISTRATION_URL)
    public String confirmUserRegistration(@RequestParam(value = USER_EMAIL) String userEmail) {
        return authService.confirmUserRegistrationByEmail(userEmail);
    }

}
