package com.ssafy.todolist.service;

import com.ssafy.todolist.domain.email.*;
import com.ssafy.todolist.repository.EmailRepository;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    private final EmailRepository emailRepository;
    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender, EmailRepository emailRepository) {
        this.javaMailSender = javaMailSender;
        this.emailRepository = emailRepository;
    }

    public String createAuthenticationNumber() {
        return Integer.toString((int) (Math.random() * 90000 + 100000));
    }

    public MimeMessage createMail(String email, String authenticationNumber) {
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            message.setFrom(email);
            message.setRecipients(MimeMessage.RecipientType.TO, email);
            message.setSubject("이메일 인증");
            StringBuilder body = new StringBuilder();
            body.append("<h3>요청하신 인증 번호 입니다.</h3>")
                    .append("<h1>")
                    .append(authenticationNumber)
                    .append("</h1>")
                    .append("<h3>감사합니다.</h3>");
            message.setText(body.toString(), "UTF-8", "html");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return message;
    }

    public EmailResponse sendCertificationNumber(String email) {
        try {
            String authenticationNumber = createAuthenticationNumber();
            javaMailSender.send(createMail(email, authenticationNumber));
            emailRepository.save(new Email(email, authenticationNumber, LocalDateTime.now().plusMinutes(5).toString()));
            return new EmailResponse(true);
        } catch (Exception e) {
            return new EmailResponse(false);
        }
    }

    public AuthenticationResponse authenticate(AuthenticationDTO authenticationDTO) {
        Email email = emailRepository.findByEmail(authenticationDTO.getEmail());
        AuthenticationDTO authenticationDTOForCheck = new AuthenticationDTO(email.getAuthenticationString(), email.getEmail(), email.getExpirationTime());
        if (authenticationDTOForCheck.getAuthenticationTime().compareTo(LocalDateTime.now().toString()) < 0) {
            return new AuthenticationResponse(false);
        }
        return new AuthenticationResponse(authenticationDTO.getAuthentication().equals(email.getAuthenticationString()));
    }

}
