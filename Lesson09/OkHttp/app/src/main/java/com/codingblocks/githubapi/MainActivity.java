package com.codingblocks.githubapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder()
                .url("https://newsapi.org/v2/top-headlines?country=in&category=business&apiKey=6ea5b3ad9ba04139b8601638cc7a61f2")
                .build();

//        client.newCall(request).execute();

//        Call call = client.newCall(request);

//        call.enqueue();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                Log.e("TAG", "onResponse: " + result);

                Gson gson = new Gson();
                Result objectResult = gson.fromJson(result,Result.class);

                ArrayList<Article> articles = objectResult.getArticles();


                //For fragment, this will be getActivity()
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //Find the Recyclerview using findVieById
                        //Set the Layout Manager
                        //Create the Adapter
                        //Set the Adapter
                    }
                });

//                for (int i =0; i< articles.size(); i++){
////
////                    Article article = articles.get(i);
////
////                }

                //For testing only
                for (Article article : articles){
                    Log.e("TAG", "onResponse: " + article.getTitle());
                }

//                MainActivity.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        textView.setText(result);
//                    }
//                });
            }
        });

//        Request request2 = new Request.Builder()
//                .url("https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=6ea5b3ad9ba04139b8601638cc7a61f2")
//                .build();
//
//        client.newCall(request2).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//
//            }
//        });

    }
}
