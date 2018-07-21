package com.codingblocks.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by harshitdwivedi on 21/07/18.
 */

public class BackgroundService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TAG", "onStartCommand: ");


        //Runs in the main thread, so don't do any long running operations here


        //Stop the service
//        stopSelf();

//        START_STICKY -> Restarts but won't pass the original intent
//        START_REDELIVER_INTENT -> Restarts and passes the original intent
//        START_NOT_STICKY -> Won't restart the service when it's killed


        return START_REDELIVER_INTENT;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "onDestroy: ");

        //A service will be killed, when
        //The app is no longer in the foreground
        //The developer called stopSelf()
    }
}
