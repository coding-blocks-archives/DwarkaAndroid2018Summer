package com.codingblocks.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Button btnTrigger = findViewById(R.id.btnTrigger);

        btnTrigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Set the alarm
                Intent intent = new Intent(getBaseContext(), NotificationBroadcast.class);
                PendingIntent pi = PendingIntent.getBroadcast(getBaseContext(),
                        1928282,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                        SystemClock.elapsedRealtime() + 1000 * 60,
                        pi
                );

//                alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
//                        SystemClock.elapsedRealtime() + 1000 * 60,
//                        5 * 60 * 1000,
//                        pi);

//                alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
//                        SystemClock.elapsedRealtime() + 1000 * 60,
//                        5 * 60 * 1000,
//                        pi);
            }
        });

    }
}
