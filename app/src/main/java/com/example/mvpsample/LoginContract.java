package com.example.mvpsample;

public interface LoginContract
{
    interface  View{
        void initV();
        void loginSuccessV(String message);
        void loginFailV(String message);
    }

    interface  Presenter{
        void initP();
        void loginClickedP(String userName, String password);
    }
}
