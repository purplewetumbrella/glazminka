package com.example.glazminka;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.view.Display;
import android.view.WindowManager;

public class ScreenMonitorService extends Service {

    private Handler mHandler = new Handler();

    private Runnable mScreenStatusChecker = new Runnable() {
        @Override
        public void run() {
            boolean isScreenOn = isScreenOn();
            sendScreenStatus(isScreenOn);
            mHandler.postDelayed(mScreenStatusChecker, 5 * 60 * 1000);
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mHandler.postDelayed(mScreenStatusChecker, 0);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mHandler.removeCallbacks(mScreenStatusChecker);
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private boolean isScreenOn() {
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        int state = display.getState();
        return state == Display.STATE_ON;
    }

    private void sendScreenStatus(boolean isScreenOn) {
        Intent screenStatusIntent = new Intent(MainActivity.ACTION_SCREEN_STATUS);
        screenStatusIntent.putExtra(MainActivity.EXTRA_SCREEN_STATUS, isScreenOn);
        sendBroadcast(screenStatusIntent);
    }
}
