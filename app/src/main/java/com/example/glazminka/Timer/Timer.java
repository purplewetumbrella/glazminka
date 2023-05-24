package com.example.glazminka.Timer;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.PowerManager;
import android.widget.TextView;

/*public class Timer extends CountDownTimer {
    private PowerManager pm;
    private PowerManager.WakeLock wl;
    private TextView timerTextView;

    public Timer(long millisInFuture, long countDownInterval, TextView timerTextView, Context context) {
        super(millisInFuture, countDownInterval);
        this.timerTextView = timerTextView;
        pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "MyApp::MyWakelockTag");
    }



    @Override
    public void onTick(long millisUntilFinished) {
        if (wl.isHeld()) {
            timerTextView.setText((int) (millisUntilFinished / 1000));
        }
    }

    @Override
    public void onFinish() {

    }

    public void startTimer() {
        wl.acquire();
        start();
    }

    public void stopTimer() {
        wl.release();
        cancel();
    }
}
*/







