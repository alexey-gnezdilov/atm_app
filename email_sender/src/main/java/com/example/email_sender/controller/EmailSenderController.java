package com.example.email_sender.controller;

import com.example.email_sender.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.email_sender.constants.EmailSenderConstants.SEND_EMAIL_URL;

@RestController
@RequiredArgsConstructor
public class EmailSenderController {

    private final EmailSenderService emailSenderService;


    @PostMapping(SEND_EMAIL_URL)
    public String receiveParametersAndSendEmail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String body) {
        return emailSenderService.sendEmail(to, subject, body);
    }
}
