package com.ssafy.todolist.controller;

import com.ssafy.todolist.domain.email.AuthenticationDTO;
import com.ssafy.todolist.domain.email.AuthenticationResponse;
import com.ssafy.todolist.domain.email.EmailDTO;
import com.ssafy.todolist.domain.email.EmailResponse;
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
    public EmailResponse sendCertificationNumber(@RequestBody EmailDTO emailDto) {
        return emailService.sendCertificationNumber(emailDto.getEmail());
    }

    @PostMapping("/authentication")
    public AuthenticationResponse authenticateCertificationNumber(@RequestBody AuthenticationDTO authenticationDTO) {
        return emailService.authenticate(authenticationDTO);
    }

}
