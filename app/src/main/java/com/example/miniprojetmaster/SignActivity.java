package com.example.miniprojetmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import model.User;
import sercices.DatabasHelper;

public class SignActivity extends AppCompatActivity {
    EditText mName;
    EditText mLastname;
    EditText mUsername;
    EditText mPassword;
    Button mSign;
    TextView mLogin;

    DatabasHelper databasHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        mName = (EditText) findViewById(R.id.sign_et_name);
        mLastname = (EditText) findViewById(R.id.sign_et_lastname);
        mUsername = (EditText) findViewById(R.id.sign_et_username);
        mPassword = (EditText) findViewById(R.id.sign_et_password);
        mSign = (Button) findViewById(R.id.sing_et_btn);
        mLogin = (TextView) findViewById(R.id.sign_tv_login);
        databasHelper  = new DatabasHelper(this);



        mSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mName.getText().toString().equals("") || mLastname.getText().toString().equals("")  ||
                        mUsername.getText().toString().equals("")
                        || mPassword.getText().toString().equals("")) {
                    //Log.i("Name",name);
                    Toast.makeText(SignActivity.this, "Test" , Toast.LENGTH_SHORT).show();
                } else {
                    User user = new User(0,mName.getText().toString(),mLastname.getText().toString(),mUsername.getText().toString(),mPassword.getText().toString());
                    databasHelper.addUser(user);
                    databasHelper.close();
                    Intent intent = new Intent(SignActivity.this , LoginActivity.class);
                    startActivity(intent);
                }
            }

        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignActivity.this , LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}