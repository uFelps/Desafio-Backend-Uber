package com.uber.email_service.controllers.exceptions;

import com.uber.email_service.controllers.exceptions.StandardError;
import com.uber.email_service.services.exceptions.EmailServiceException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(EmailServiceException.class)
    public ResponseEntity<StandardError> emailServiceException(EmailServiceException e, HttpServletRequest request){

        StandardError error = new StandardError();
        HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE;
        error.setStatus(status.value());
        error.setError("Error on Email Service");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        error.setTimestamp(Instant.now());

        return ResponseEntity.status(status).body(error);
    }
}
