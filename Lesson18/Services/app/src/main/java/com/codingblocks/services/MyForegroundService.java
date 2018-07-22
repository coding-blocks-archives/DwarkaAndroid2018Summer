package com.codingblocks.services;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

/**
 * Created by harshitdwivedi on 21/07/18.
 */

public class MyForegroundService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
        MyPowerReceiver powerReceiver = new MyPowerReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        registerReceiver(powerReceiver,intentFilter);
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (intent.hasExtra("STOP")) {
            stopSelf();
        }

        Intent startService = new Intent(this, MyForegroundService.class);
        startService.putExtra("STOP", true);

        PendingIntent pi = PendingIntent.getService(this,
                12345,
                startService,
                PendingIntent.FLAG_ONE_SHOT);

        final Notification notification = new NotificationCompat.Builder(this, MainActivity.CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Hi I'm a notification")
                .setContentText("Welcome to Coding Blocks!")
                .addAction(R.mipmap.ic_launcher, "Stop", pi)
                .build();

        startForeground(1234, notification);

        return START_REDELIVER_INTENT;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
