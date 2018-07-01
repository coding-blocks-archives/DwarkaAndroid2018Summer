package com.codingblocks.githubuser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url("https://api.github.com/search/users?q=harshit")
                .build();


        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

//                ResponseBody responseBody = response.body();

                //THIS IS NOT .toString()!
//                Log.e("TAG", "onResponse: " + responseBody.string() );

                String userApi = response.body().string();
                Gson gson = new Gson();

                Result result = gson.fromJson(userApi,Result.class);

                final ArrayList<User> userArrayList = result.getItems();

                //Get instance of current Activity
                AppCompatActivity x = MainActivity.this;

                //Anything inside onResponse runs on the background thread

                x.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //This code runs on the UI thread
                        UserAdapter userAdapter = new UserAdapter(userArrayList);
                        RecyclerView recyclerView = findViewById(R.id.rvUsers);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

                        recyclerView.setAdapter(userAdapter);

                    }
                });

                //Response implements a Closeable interface and hence
                // allows direct reading only once
//                Log.e("TAG", "onResponse: " + response.body().string());


            }
        });

    }
}
