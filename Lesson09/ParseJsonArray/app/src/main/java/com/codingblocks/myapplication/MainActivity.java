package com.codingblocks.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

// https://api.github.com/users/harshit98/repos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String repoResponse = "";

        Gson gson = new Gson();

//        try {
//            JSONArray jsonArray = new JSONArray(repoResponse);
//
//            for (int i = 0; i < jsonArray.length() ; i++){
//
//                Repo currentRepo = gson.fromJson(jsonArray.getJSONObject(i).toString(),
//                        Repo.class);
//
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


        Repo[] repos = gson.fromJson(repoResponse,Repo[].class);
    }
}
