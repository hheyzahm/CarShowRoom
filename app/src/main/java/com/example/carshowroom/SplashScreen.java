package com.example.carshowroom;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;


public class SplashScreen extends AppCompatActivity {

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.lined_logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
                new Handler().postDelayed(new Runnable() {
            @Override public void run() {

                Intent i = new Intent(SplashScreen.this,UserNameActivity.class);
                startActivity(i);
                finish();
            }
            }, 5000);
    }

}
