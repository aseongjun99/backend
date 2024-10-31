package com.ssafy.todolist.oauth.dto;

public class OAuthSuccessResponse {

    private String refreshToken;
    private String accessToken;

    public OAuthSuccessResponse(String refreshToken, String accessToken) {
        this.refreshToken = refreshToken;
        this.accessToken = accessToken;
    }

}
