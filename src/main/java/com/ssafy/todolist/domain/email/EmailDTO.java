package com.ssafy.todolist.domain.email;

public class EmailDTO {
    private String email;

    public EmailDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    protected EmailDTO() {

    }

}
