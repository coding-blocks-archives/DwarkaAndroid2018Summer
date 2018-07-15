package com.codingblocks.taskroom;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.view.View;

public class MyViewModel extends ViewModel {

    private String jsonResponse = "";

    public String getJsonResponse() {

        if (jsonResponse.equals("")){
//            jsonResponse = makeOkHttpCall();
        }
        return jsonResponse;
    }

    public String forceNetworkCal(){
//        jsonResponse = makeOkHttpCall();
        return jsonResponse;
    }

    LiveData<String> responseLive;

    public LiveData<String> getResponseLive() {
//        makeOkHttpCall();
        return responseLive;
    }

//    private void makeOkHttpCall() {
//        okhttpClient.newCall(x).enqueue(
//
//                onResponse(ResponseBody b){
//                    responseLive = xyz;
//        }
//                onFailure(Exception e){
//
//        });
//    }

}
