package com.ssafy.todolist.controller;

import com.ssafy.todolist.domain.email.AuthenticationDTO;
import com.ssafy.todolist.domain.email.AuthenticationResponse;
import com.ssafy.todolist.domain.email.EmailDTO;
import com.ssafy.todolist.domain.email.EmailResponse;
import com.ssafy.todolist.service.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/email")
@RestController
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping()
    public EmailResponse sendAuthentication(@RequestBody EmailDTO emailDto) {
        return emailService.sendAuthentication(emailDto.getEmail());
    }

    @PostMapping("/authentication")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationDTO authenticationDTO) {
        return emailService.authenticate(authenticationDTO);
    }

}
