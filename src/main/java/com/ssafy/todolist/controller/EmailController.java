package com.ssafy.todolist.controller;

import com.ssafy.todolist.domain.AuthenticationResponse;
import com.ssafy.todolist.domain.EmailResponse;
import com.ssafy.todolist.service.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/email")
    public EmailResponse sendCertificationNumber(@RequestBody Map<String, String> email) {
        return emailService.sendCertificationNumber(email.get("email"));
    }

    @PostMapping("/authentication")
    public AuthenticationResponse authenticateCertificationNumber(@RequestBody Map<String, String> authentication) {
        return emailService.authenticateCertificationNumber(authentication.get("authentication"));
    }

}
