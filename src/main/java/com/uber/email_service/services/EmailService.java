package com.uber.email_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailSenderService primaryEmailSenderService;

    public EmailService(AmazonSesSenderSenderService primaryEmailSenderService){
        this.primaryEmailSenderService = primaryEmailSenderService;
    }

    public void sendEmail(String to, String subject, String body){
        primaryEmailSenderService.sendEmail(to, subject, body);
    }
}
