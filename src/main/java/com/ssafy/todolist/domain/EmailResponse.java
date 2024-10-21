package com.ssafy.todolist.domain;

public class EmailResponse {
    private final boolean isOk;

    public EmailResponse(boolean isOk) {
        this.isOk = isOk;
    }

    public boolean getIsOk() {
        return this.isOk;
    }

}