package com.example.email_sender.service;

public interface EmailSenderService {

    String sendEmail(String to, String subject, String body);

}
