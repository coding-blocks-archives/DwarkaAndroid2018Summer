package com.codingblocks.workmanager;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.State;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.WorkStatus;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final WorkManager wm = WorkManager.getInstance();

        Constraints constraints = new Constraints();
        constraints.setRequiredNetworkType(NetworkType.CONNECTED);
        constraints.setRequiresBatteryNotLow(true);
        constraints.setRequiresCharging(true);
        constraints.setRequiresStorageNotLow(false);

        Button btnWork = findViewById(R.id.doWork);

        Data data = new Data.Builder()
                .putFloat("FLOAT", 3.0F)
                .putInt("INT", 5)
                .build();


        //If the delay is not set, the task is executed immediately after checking constraints
        final WorkRequest workRequest = new OneTimeWorkRequest.Builder(MyWorker.class)
                .setInitialDelay(5, TimeUnit.SECONDS)
                //Sets some data to your Worker class
                .setInputData(data)
                .setConstraints(constraints)
                .build();


        final WorkRequest periodicRequest = new PeriodicWorkRequest.Builder(MyWorker.class,
                1, TimeUnit.DAYS)
                .setConstraints(constraints)
                .build();

        btnWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                wm.enqueue(workRequest);
            }
        });

        LiveData<WorkStatus> liveData = wm.getStatusById(workRequest.getId());


        liveData.observe(this, new Observer<WorkStatus>() {
            @Override
            public void onChanged(@Nullable WorkStatus workStatus) {

//                if (workStatus.getState() == State.) {
//
//                }

            }
        });

    }
}
