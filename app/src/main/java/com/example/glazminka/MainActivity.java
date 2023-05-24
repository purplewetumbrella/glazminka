package com.example.glazminka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;

import android.content.Context;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.os.Bundle;

import android.os.CountDownTimer;
import android.os.PowerManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    private CountDownTimer сountdownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView TextView = findViewById(R.id.timer_text_view);
        CountdownTimer countdownTimer = new CountdownTimer();

        countdownTimer.start(TextView);





        Button btnGoToSecAct = (Button) findViewById(R.id.btnGoToSecAct);

        btnGoToSecAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity_2.class);
                startActivity(intent);
                countdownTimer.cancel();
            }
        });







    }


}





