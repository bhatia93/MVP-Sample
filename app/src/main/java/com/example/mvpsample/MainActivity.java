package com.example.mvpsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvpsample.Model.AppPrefs;
import com.example.mvpsample.presenter.MainActivityPresenter;

public class MainActivity extends AppCompatActivity  implements LoginContract.View
{
    EditText et_name, et_password;
    TextView tv_status;
    Button btn_login;
    LoginContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter=new MainActivityPresenter(this,this);
        mPresenter.initP();
    }

    @Override
    public void initV() {
        AppPrefs.init(this);
        AppPrefs.setUserName("ayusch");
        AppPrefs.setPassword("ayusch123");

//        et_name = findViewById(R.id.et_name);
//        et_password = findViewById(R.id.et_password);
//        btn_login = findViewById(R.id.btn_login);
//        tv_status = findViewById(R.id.tv_status);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.loginClickedP(et_name.getText().toString(), et_password.getText().toString());
            }
        });
    }


    @Override
    public void loginFailV(String message) {
        tv_status.setText(message);
    }

    @Override
    public void loginSuccessV(String message) {
        tv_status.setText(message);
    }
}