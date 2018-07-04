package com.codingblocks.localbbroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend = findViewById(R.id.btnSendBroadcast);

        MyReceiver myReceiver = new MyReceiver();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.codingblocks.localbroadcast");

//        registerReceiver(myReceiver, intentFilter);

        //LocalBroadcast sends the broadcast only to the Receivers of my own app
        LocalBroadcastManager.getInstance(this).registerReceiver(myReceiver,
                intentFilter);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("USERNAME", "the-dagger");
                intent.putExtra("PASSWORD", "********");
                intent.setAction("com.codingblocks.localbroadcast");

//                sendBroadcast(intent);

                LocalBroadcastManager.getInstance(getBaseContext())
                        .sendBroadcast(intent);
            }
        });

    }
}
