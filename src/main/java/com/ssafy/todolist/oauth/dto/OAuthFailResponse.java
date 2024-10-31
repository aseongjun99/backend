package com.ssafy.todolist.oauth.dto;

public class OAuthFailResponse {

    private String status;
    private String code;

    public OAuthFailResponse(String status, String code) {
        this.status = status;
        this.code = code;
    }
}
