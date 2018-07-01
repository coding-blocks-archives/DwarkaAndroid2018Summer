package com.codingblocks.githubuser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent receivedIntent = getIntent();

//        String url = receivedIntent.getStringExtra("URL");
//        String repoUrl = receivedIntent.getStringExtra("REPO");

        User user = (User) receivedIntent.getParcelableExtra("USER");

        OkHttpClient client = new OkHttpClient();

        updateUserDetails(user.getUrl(), client);
        updateRepoDetails(user.getReposUrl(), client);
    }

    private void updateUserDetails(String url, OkHttpClient client) {

        final Request request = new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String userDetail = response.body().string();
                Gson gson = new Gson();

                DetailUser detailUser = gson.fromJson(userDetail, DetailUser.class);

                DetailActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //Update the UI here
                    }
                });


            }
        });
    }

    private void updateRepoDetails(String repoUrl, OkHttpClient client) {

        Request request = new Request.Builder()
                .url(repoUrl).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });


    }
}
