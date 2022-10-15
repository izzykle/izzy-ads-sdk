package com.izzy.ads.sdkdemo;

import static com.izzy.ads.sdk.util.Constant.ADMOB;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySplash extends AppCompatActivity {

    private static final long COUNTER_TIME = 2000;
    long secondsRemaining;
    Application application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        application = ((MyApplication) getApplication());
        ((MyApplication) application).showAdIfAvailable(ActivitySplash.this, this::createTimer);

    }

    private void createTimer() {

        CountDownTimer countDownTimer = new CountDownTimer(COUNTER_TIME, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                secondsRemaining = ((millisUntilFinished / 1000) + 1);
            }

            @Override
            public void onFinish() {
                secondsRemaining = 0;
                startMainActivity();
            }
        };
        countDownTimer.start();
    }

    public void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

}
