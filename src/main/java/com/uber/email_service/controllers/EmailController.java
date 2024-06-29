package com.uber.email_service.controllers;

import com.uber.email_service.dto.EmailDTO;
import com.uber.email_service.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService service;

    @PostMapping
    public ResponseEntity<Void> sendEmail(@RequestBody EmailDTO dto){
        service.sendEmail(dto.getTo(), dto.getSubject(), dto.getBody());
        return ResponseEntity.ok().build();
    }
}
