package com.akp.rbandolan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    ImageView image;
    TextView tvlab;
    private int DELAY = 2000;
    private SharedPreferences sharedPreferences;
    String username;
    String versionName = "", versionCode = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        findViewById();
    }

    private void findViewById() {
        image = findViewById(R.id.image);
        sharedPreferences = getSharedPreferences("login_preference", MODE_PRIVATE);
        username = sharedPreferences.getString("username", "");
       /* Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation);
        image.startAnimation(animation1);
        tvlab.startAnimation(animation1);*/
        checkLogin();
    }

    private void checkLogin() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (username.equalsIgnoreCase("")) {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }}}, DELAY);
    }
}