package com.codingblocks.okhttppost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etEmail = findViewById(R.id.etEmail), etPassword = findViewById(R.id.etPassword);

        Button btn = findViewById(R.id.btnPost);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student student = new Student(etEmail.getText().toString(), etPassword.getText().toString());
                postStudentToServer(student);
            }
        });


    }

    private void postStudentToServer(Student student) {

        OkHttpClient okHttpClient = new OkHttpClient();

        //This will be provided by your employer
        String posrUrl = "http://ptsv2.com/t/dsp4n-1530702440/post";

//        "application/json"

        //Set the type of document that we will be sendin
        MediaType mediaType = MediaType.parse("application/json");

        //Create the request body, i.e. the request that we will send to the server
        RequestBody requestBody = RequestBody.create(mediaType, "{ hello : world }");

        //We create the request object
        final Request request = new Request.Builder()
                .url(posrUrl)
                .post(requestBody)
                .build();

        //Use client to make a call to the request object
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result  =response.body().string();

                Log.e("TAG", "onResponse: " + result);


            }
        });

    }
}
