package com.example.glazminka;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {

    private static final long TOTAL_TIME = 5400000; // 1.5 часа в миллисекундах
    private CountDownTimer timer;

    public void start(final TextView textView) {
        timer = new CountDownTimer(TOTAL_TIME, 1000) { // запускаем таймер на 1 секунду
            public void onTick(long millisUntilFinished) {
                long seconds = millisUntilFinished / 1000;
                long minutes = seconds / 60;
                seconds = seconds % 60;
                textView.setText(String.format("%02d:%02d", minutes, seconds)); // форматируем и устанавливаем текст в TextView
            }

            public void onFinish() {
                textView.setText("00:00");
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
                }, 0, 1000);// устанавливаем текст в TextView по завершении таймера
            }

            private void runOnUiThread(Runnable runnable) {
            }
        }.start();
    }

    public void cancel() {
        if (timer != null) {
            timer.cancel(); // отменяем таймер, если он запущен
        }
    }
}
