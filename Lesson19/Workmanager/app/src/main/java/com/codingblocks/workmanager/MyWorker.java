package com.codingblocks.workmanager;

import android.app.NotificationManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.Data;
import androidx.work.Worker;

/**
 * Created by harshitdwivedi on 22/07/18.
 */

public class MyWorker extends Worker {

    @NonNull
    @Override
    public Result doWork() {

        Data data = getInputData();

        Log.e("TAG", "doWork: ");

        //Do your scheduled wok here

//        getApplicationContext();


//        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        //This runs in a background thread
        //You can't update UI from here

        return Result.SUCCESS;

        //Does not retry in SUCCESS and FAILURE
        //Retries in RETRY
    }


}
