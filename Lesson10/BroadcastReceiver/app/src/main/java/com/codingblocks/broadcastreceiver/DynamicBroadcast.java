package com.codingblocks.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class DynamicBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("TAG", "onReceive: was called" );

        switch (intent.getAction()){
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                //Handle Airplane mode
                break;
        }

        Toast.makeText(context, "onReceive: was called", Toast.LENGTH_SHORT).show();
    }
}
