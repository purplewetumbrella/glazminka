package com.example.glazminka;

import android.app.AlertDialog;
import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {
    boolean finish;

    private static final long TOTAL_TIME = 5400000; // 1.5 часа в миллисекундах
    private CountDownTimer timer;
    private long remainingTime;
    private long remainingMillis;
    private Object context;

    public void start(final TextView textView) {
        finish = false;
        timer = new CountDownTimer(TOTAL_TIME, 1000) {
            
           
            public void onTick(long millisUntilFinished) {
                remainingMillis = millisUntilFinished;
                long seconds = millisUntilFinished / 1000;
                long minutes = seconds / 60;
                seconds = seconds % 60;
                textView.setText(String.format("%02d:%02d", minutes, seconds)); 
            }
            

            public void onFinish() {



                final Timer timer = new Timer();

                timer.scheduleAtFixedRate(new TimerTask() {

                    int seconds = 0;

                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                textView.setText("-" + seconds++);
                            }
                        });
                    }
                }, 0, 1000);
            }

            private void runOnUiThread(Runnable runnable) {
            }
        }.start();
    }



    public void resumeTimer(final TextView textView) {
        timer = new CountDownTimer(remainingTime, 1000) {
            public void onTick(long millisUntilFinished) {
                long seconds = millisUntilFinished / 1000;
                long minutes = seconds / 60;
                seconds = seconds % 60;
                textView.setText(String.format("%02d:%02d", minutes, seconds));
            }
            public void onFinish() {

                
                final Timer timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {

                    int seconds = 0;

                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                textView.setText("-" + seconds++);
                            }
                        });
                    }

                   
                }, 0, 1000);
            }

            private void runOnUiThread(Runnable runnable) {
            }
        }.start();
    }

    public void resetTimer(final TextView textView) {
        cancel();
        remainingTime = TOTAL_TIME;
        start(textView);
    }

    public void cancel() {
        if (timer != null) {
            timer.cancel();
        }
    }
    public void saveTimer() {
        if (timer != null) {
            cancel();
            remainingTime =  remainingMillis;
        }
    }



}
