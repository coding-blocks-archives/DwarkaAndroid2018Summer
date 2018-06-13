package com.codingblocks.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent i = getIntent();

        String name = i.getStringExtra("KEY");
        int a = i.getIntExtra("KEY2",0);

        TextView tvName = findViewById(R.id.tvResult);
        tvName.setText(name);
    }
}
