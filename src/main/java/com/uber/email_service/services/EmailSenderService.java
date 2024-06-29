package com.uber.email_service.services;

public interface EmailSenderService {
    void sendEmail(String to, String subject, String body);
}
