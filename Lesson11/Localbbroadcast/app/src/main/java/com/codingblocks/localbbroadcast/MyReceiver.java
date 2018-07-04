package com.codingblocks.localbbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("TAG", "onReceive: ");
        Toast.makeText(context, "Receiver was called", Toast.LENGTH_SHORT).show();
    }
}
