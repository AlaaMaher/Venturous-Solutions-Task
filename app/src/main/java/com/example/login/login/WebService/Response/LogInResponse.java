package com.example.login.login.WebService.Response;

/**
 * Created by acer on 03/10/18.
 */

public class LogInResponse {
    private int status;
    private int api_token;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getApi_token() {
        return api_token;
    }

    public void setApi_token(int api_token) {
        this.api_token = api_token;
    }
}
