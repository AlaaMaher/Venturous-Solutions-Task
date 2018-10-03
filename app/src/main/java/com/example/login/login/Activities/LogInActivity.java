package com.example.login.login.Activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.login.login.R;
import com.example.login.login.Model.User;
import com.example.login.login.ViewModel.LogInVM;
import com.example.login.login.databinding.ActivityLoginBinding;

public class LogInActivity extends AppCompatActivity {


    ActivityLoginBinding binding;
    private User mUser =new User();
    private LogInVM logInVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      binding= DataBindingUtil.setContentView(this, R.layout.activity_login);
      logInVM=new LogInVM(this,mUser);
      binding.setLogInVM(logInVM);
    }
}
