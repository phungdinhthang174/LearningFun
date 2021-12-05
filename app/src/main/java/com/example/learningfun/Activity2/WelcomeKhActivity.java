package com.example.learningfun.Activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.learningfun.Activity.KHActivity;
import com.example.learningfun.R;
import com.example.learningfun.SignInActivity;
import com.example.learningfun.WelcomeScreen;

public class WelcomeKhActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_kh);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeKhActivity.this, KHActivity.class));
                finish();
            }
        },2300);
    }
}