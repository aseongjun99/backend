package com.ssafy.todolist.domain.email;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "email")
public class Email {

    @Id
    private String email;

    @Column(nullable = false)
    private String authenticationString;

    public Email() {}

    public Email(String email, String authenticationString) {
        this.email = email;
        this.authenticationString = authenticationString;
    }

    public String getAuthenticationString() {
        return authenticationString;
    }

    public String getEmail() {
        return email;
    }
}
