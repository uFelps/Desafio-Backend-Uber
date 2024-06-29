package com.uber.email_service.services;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.uber.email_service.services.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AmazonSesSenderSenderService implements EmailSenderService {

    @Value("${email.source}")
    private String emailSource;

    @Autowired
    private final AmazonSimpleEmailService amazonSimpleEmailService;

    public AmazonSesSenderSenderService(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {

        SendEmailRequest emailRequest = new SendEmailRequest()
                .withSource(emailSource)
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body)))
                );

        try {
            amazonSimpleEmailService.sendEmail(emailRequest);
        } catch (AmazonServiceException e) {
            throw new EmailServiceException("Error on AWS SES. Check your credentials");
        }
    }
}
