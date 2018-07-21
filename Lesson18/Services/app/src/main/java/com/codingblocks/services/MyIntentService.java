package com.codingblocks.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by harshitdwivedi on 21/07/18.
 */

public class MyIntentService extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
    */
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //This will run in a different thread

        //Do long running operations here


        //IntentService will be killed when either :
        //1 Its work is done
        //2 The app is no longer in the foreground
    }
}
