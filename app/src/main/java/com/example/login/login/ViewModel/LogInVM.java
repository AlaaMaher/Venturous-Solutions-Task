package com.example.login.login.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import android.widget.Toast;

import com.example.login.login.BR;
import com.example.login.login.Model.User;
import com.example.login.login.WebService.Request.LogInRequest;
import com.example.login.login.WebService.Response.LogInResponse;
import com.example.login.login.WebService.RetrofitWebService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by acer on 02/10/18.
 */

public class LogInVM extends BaseObservable {

    private Context context;
    private User user;
    //private String errorPassword;

    public LogInVM (Context context, User user){
        this.context=context;
        this.user=user;
    }

    @Bindable
    public String getUserName() {
        return user.userName;
    }

    public void setUserName(String userName) {
        user.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getUserPassword() {
        return user.userPassword;
    }

    public void setUserPassword(String userPassword) {
        user.userPassword = userPassword;
      //  isValidPassword(userPassword);
        notifyPropertyChanged(BR.userPassword);
      //  notifyPropertyChanged(BR.errorPassword);

    }


//    @Bindable
//    public String getErrorPassword() {
//        if (getUserPassword() == null) {
//            return "Please Enter";
//        } else if (getUserPassword().length() < 8) {
//            return "Too Short..!!";
//        } else if (!isValidPassword(getUserPassword())) {
//            return "Your Password Must be combination of \n Small,Captital & Special Characters";
//        } else {
//            return null;
//        }
//    }

//    public static boolean isValidPassword(final String password) {
//        Pattern pattern;
//        Matcher matcher;
//        final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
//        pattern = Pattern.compile(PASSWORD_PATTERN);
//
//        matcher = pattern.matcher(password);
//        return matcher.matches();
//    }

    public void onLogInClicked(View view){

        if (getUserName()==null){
            Toast.makeText(context, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
        }
        else if (getUserPassword()==null){
            Toast.makeText(context, "Please Enter Your Password", Toast.LENGTH_SHORT).show();
        }
        else {
            login ();
            //Intent intent = new Intent(ctx, HomeScreen.class);
            //ctx.startActivity(intent);

        }

    }

    private void login(){

        LogInRequest logInRequest=new LogInRequest(getUserName(),getUserPassword());
        RetrofitWebService.getService().logInFun(logInRequest).enqueue(new Callback<LogInResponse>() {
            @Override
            public void onResponse(Call<LogInResponse> call, Response<LogInResponse> response) {
                Toast.makeText(context, "Status" + response.body().getStatus(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<LogInResponse> call, Throwable t) {

                Toast.makeText(context, "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
