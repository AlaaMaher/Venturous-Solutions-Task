package com.example.login.login.WebService.Request;

/**
 * Created by acer on 03/10/18.
 */

public class LogInRequest {
    private String UserName;
    private String Password;

    public LogInRequest(String UserName, String Password ){
        this.UserName=UserName;
        this.Password=Password;
    }
}
