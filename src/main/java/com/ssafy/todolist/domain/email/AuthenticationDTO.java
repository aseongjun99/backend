package com.ssafy.todolist.domain.email;

public class AuthenticationDTO {

    private String authentication;
    private String email;
    private String authenticationTime;

    public AuthenticationDTO(String authentication, String email, String authenticationTime) {
        this.authentication = authentication;
        this.email = email;
        this.authenticationTime = authenticationTime;
    }

    public String getAuthentication() {
        return authentication;
    }

    public String getEmail() {
        return email;
    }

    public String getAuthenticationTime() {
        return authenticationTime;
    }

}
