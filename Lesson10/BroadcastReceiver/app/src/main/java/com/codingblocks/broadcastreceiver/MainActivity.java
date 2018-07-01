package com.codingblocks.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    DynamicBroadcast dynamicBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent i = getIntent();
        String receivedString = i.getStringExtra("KEY");
        dynamicBroadcast = new DynamicBroadcast();
        Button start = findViewById(R.id.buttonStartListening);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Register the reciever
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
                intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
                intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);

                registerReceiver(dynamicBroadcast, intentFilter);
            }
        });

        Button stop = findViewById(R.id.buttonStopListening);


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Unregister the receiver
                unregisterReceiver(dynamicBroadcast);
            }
        });

        Button startActivity = findViewById(R.id.button3);

        startActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                //Set a custom action to this intent
                i.setAction("HelloActivity");
                //Send this broadcast to all the Receivers
                // which have registered for "HelloActivity" action
                sendBroadcast(i);
            }
        });
    }
}
