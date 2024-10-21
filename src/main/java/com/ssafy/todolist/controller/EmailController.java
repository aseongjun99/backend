package com.ssafy.todolist.controller;

import com.ssafy.todolist.domain.EmailResponse;
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

    @PostMapping
    public EmailResponse sendCertificationNumber(@RequestBody Map<String, String> email) {
        return emailService.sendCertificationNumber(email.get("email"));
    }

}
