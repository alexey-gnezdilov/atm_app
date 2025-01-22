package com.example.auth_module.service.impl;

import com.example.auth_module.model.ConfirmRegistrationDto;
import com.example.auth_module.service.IntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class IntegrationServiceImpl implements IntegrationService {

    private final RestTemplate restTemplate;

    @Override
    public String sendConfirmationMessage(ConfirmRegistrationDto info) {

        return restTemplate.exchange(
                "http://127.0.0.1:8089/send",
                HttpMethod.POST,
                new HttpEntity<>(info,null),
                String.class
        ).getBody();
    }
}
