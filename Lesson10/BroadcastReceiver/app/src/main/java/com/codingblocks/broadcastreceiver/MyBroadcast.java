package com.codingblocks.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "OnReceived was called", Toast.LENGTH_SHORT).show();
//        Intent i = new Intent(context,MainActivity.class);
//

        Intent i = new Intent(context, MainActivity.class);

        //I am starting a new task here
        //If you are starting an activity from a non-activity context
        // then you need to set this flag
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


        switch (intent.getAction()) {
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                //Handle Airplane Mode
                break;
            case Intent.ACTION_POWER_CONNECTED:
                //Handle power connected
                i.putExtra("KEY", "Connected");
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                i.putExtra("KEY", "Disconnected");
                break;
        }
        context.startActivity(i);
        //Tell the broadcast Receiver that some work is going to be
        // done in the background thread
//        final PendingResult pendingResult = goAsync();
//
//        //Create a new thread for long running tasks as the
//        // Broadcast runs on UI thread by default
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //Do long running process
//
//                //It's our responsibility to tell the OS when the
//                // work was finished by calling finish() on the pendingResult object
//                // so that this BroadCastReceiver object can be reused or garbage collected
//                pendingResult.finish();
//            }
//        });

//        context.startActivity(i);
    }
}
