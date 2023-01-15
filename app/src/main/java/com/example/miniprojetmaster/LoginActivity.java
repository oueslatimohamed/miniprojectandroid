package com.example.miniprojetmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import sercices.DatabasHelper;

public class LoginActivity extends AppCompatActivity {
    EditText mLogin;
    EditText mPassword;
    Button mLogin_btn;
    TextView mRegister;

    DatabasHelper databasHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLogin = (EditText) findViewById(R.id.login_et_login);
        mPassword = (EditText) findViewById(R.id.login_et_password);
        mLogin_btn = (Button) findViewById(R.id.login_et_btn);
        mRegister = (TextView) findViewById(R.id.login_tv_register);


        databasHelper = new DatabasHelper(this);

        String login = mLogin.getText().toString();
        String password = mPassword.getText().toString();

        mLogin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean var = databasHelper.checkUser(mLogin.getText().toString(),mPassword.getText().toString());
                if(mLogin.getText().toString().equals("")||mPassword.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Login empty" , Toast.LENGTH_SHORT).show();
                } else {
                    if(var == true) {
                        Toast.makeText(LoginActivity.this, "Login" , Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this , MainActivity.class);
                        intent.putExtra("Login", mLogin.getText().toString());
                        startActivity(intent);

                    } else {
                        Toast.makeText(LoginActivity.this, "Login failed" , Toast.LENGTH_SHORT).show();
                    }
                }
                //Log.i("TEST LOGIN" , String.valueOf(var));

            }
        });


        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this , SignActivity.class);
                startActivity(intent);
            }
        });
    }
}