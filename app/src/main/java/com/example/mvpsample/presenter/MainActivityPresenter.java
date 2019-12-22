package com.example.mvpsample.presenter;

import android.content.Context;

import com.example.mvpsample.LoginContract;
import com.example.mvpsample.Model.AppPrefs;

public class MainActivityPresenter implements LoginContract.Presenter{
    private final Context context;
    LoginContract.View mView;

    public MainActivityPresenter(Context context,LoginContract.View mView){
        this.mView=mView;
        this.context=context;
    }

    @Override
    public void initP(){
        mView.initV();
    }

    @Override
    public void loginClickedP(String userName, String password)
    {
        if (userName.isEmpty() || password.isEmpty()) {
            mView.loginFailV("Please enter all the details");
        } else {
            if (userName.equals(AppPrefs.getUserName()) && password.equals(AppPrefs.getPassword())) {
                mView.loginSuccessV("Login Successful!!");
            } else {
                mView.loginFailV("Wrong username/password");
            }
        }
    }


}
