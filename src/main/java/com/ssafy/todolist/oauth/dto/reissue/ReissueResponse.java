package com.ssafy.todolist.oauth.dto.reissue;

public class ReissueResponse {

    private String accessToken;

    public ReissueResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
