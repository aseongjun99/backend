package com.ssafy.todolist.oauth.dto;

public class OAuthDTO {

    private String code;

    public OAuthDTO(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
