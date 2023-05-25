package com.example.glazminka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {
    public static final String ACTION_SCREEN_STATUS = "com.example.app.ACTION_SCREEN_STATUS";
    public static final String EXTRA_SCREEN_STATUS = "extra_screen_status";

    private CountDownTimer сountdownTimer;
    private boolean isScreenOn = true;
    final Timer timer1 = new Timer();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView TextView = findViewById(R.id.timer_text_view);
        CountdownTimer countdownTimer = new CountdownTimer();


        countdownTimer.start(TextView);

        if (!isScreenOn) {
            countdownTimer.saveTimer();
            while (!isScreenOn) {
                countdownTimer.resumeTimer(TextView);
            }
            countdownTimer.saveTimer();
        }


        Button btnGoToSecAct = (Button) findViewById(R.id.btnGoToSecAct);

        btnGoToSecAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_2.class);
                startActivity(intent);
                countdownTimer.cancel();
                countdownTimer.resetTimer(TextView);
            }
        });

    }


    private BroadcastReceiver mScreenStatusReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            isScreenOn = intent.getBooleanExtra(EXTRA_SCREEN_STATUS, false);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mScreenStatusReceiver, new IntentFilter(ACTION_SCREEN_STATUS));
    }

    @Override
    protected void onPause() {
        unregisterReceiver(mScreenStatusReceiver);
        super.onPause();
    }










}





