package com.example.glazminka.Timer;
import android.os.PowerManager;
import android.widget.TextView;
import android.os.CountDownTimer;

public class CountdownTimer extends CountDownTimer {
    Timer timer= new Timer();

    private TextView countdownText;
    private boolean timerRunning;
    private long timeLeftInMillis;
    private long pauseTime;
    private PowerManager.WakeLock wakeLock;

    public CountdownTimer(long millisInFuture, TextView countdownText, PowerManager powerManager) {
        super(millisInFuture, 1000);
        this.countdownText = countdownText;
        this.timerRunning = false;
        this.timeLeftInMillis = millisInFuture;
        this.pauseTime = 0;
        this.wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                "CountdownTimer::WakeLock");
    }

    public void startTimer() {
        if (!timerRunning) {
            start();
            timerRunning = true;
            wakeLock.acquire(timeLeftInMillis + 1000);
        }
    }

    public void stopTimer() {
        if (timerRunning) {
            cancel();
            timerRunning = false;
            wakeLock.release();
        }
    }
    public void pauseTimer() {
        if (timerRunning) {
            pauseTime = timeLeftInMillis;
            cancel();
            timerRunning = false;
            wakeLock.release();
        }
    }
    public long getRemainingTime() {
        return timeLeftInMillis;
    }
    public long getPauseTime() {
        return pauseTime;
    }
    @Override
    public void onTick(long millisUntilFinished) {
        timeLeftInMillis = millisUntilFinished;
        updateCountdownText();
    }

    @Override
    public void onFinish() {
        stopTimer();
       // startTimer(); // запуск второго таймера, считает сколько прошло с момента окончания первого таймера
    }
    private void updateCountdownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format("%02d:%02d", minutes, seconds);
        countdownText.setText(timeLeftFormatted);
    }
}



