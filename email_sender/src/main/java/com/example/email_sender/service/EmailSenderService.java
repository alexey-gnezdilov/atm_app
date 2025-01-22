package com.example.email_sender.service;

import com.example.email_sender.model.ConfirmRegistrationDto;

public interface EmailSenderService {

    String sendEmail(ConfirmRegistrationDto info);

}
