package com.ssafy.todolist.domain.email;

public class AuthenticationDTO {

    private String authentication;
    private String email;

    public AuthenticationDTO(String authentication, String email) {
        this.authentication = authentication;
        this.email = email;
    }

    public String getAuthentication() {
        return authentication;
    }

    public String getEmail() {
        return email;
    }

}
