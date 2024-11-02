package com.ssafy.todolist.oauth.dto;

public class AuthFailResponse {

    private final int status = 400;
    private final String code = "ERR_MISSING_AUTHORIZATION_CODE";

    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }
}
