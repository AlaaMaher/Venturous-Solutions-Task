package com.example.login.login.WebService;

import com.example.login.login.WebService.Request.LogInRequest;
import com.example.login.login.WebService.Response.LogInResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by acer on 03/10/18.
 */

public interface RetrofitService {

    @POST("Login")
    Call<LogInResponse> logInFun(@Body LogInRequest logInRequest);

}
