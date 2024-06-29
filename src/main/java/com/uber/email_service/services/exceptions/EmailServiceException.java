package com.uber.email_service.services.exceptions;

public class EmailServiceException extends RuntimeException {
    public EmailServiceException(String message){
        super(message);
    }
}
