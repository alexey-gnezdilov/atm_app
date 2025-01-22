package com.example.auth_module.service;

import com.example.auth_module.model.ConfirmRegistrationDto;

public interface IntegrationService {

    String sendConfirmationMessage(ConfirmRegistrationDto info);
}
