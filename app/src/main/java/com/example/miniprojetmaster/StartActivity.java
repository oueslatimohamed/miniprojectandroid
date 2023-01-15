package com.example.miniprojetmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    Button mLogin_btn;
    Button mSign_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        mLogin_btn = (Button) findViewById(R.id.start_btn_login);
        mSign_btn = (Button) findViewById(R.id.start_btn_sign);


        mLogin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this , LoginActivity.class);
                startActivity(intent);
            }
        });

        mSign_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this , SignActivity.class);
                startActivity(intent);
            }
        });
    }
}