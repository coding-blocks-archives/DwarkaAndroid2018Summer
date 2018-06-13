package com.codingblocks.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSend = findViewById(R.id.btnSend);
        final EditText etName = findViewById(R.id.etName);
        TextView tvResult = findViewById(R.id.tvResult);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("KEY",name);
//                i.putExtra("KEY2",5);
                startActivity(i);
                finish(); //Kills the activity. Calling onDestroy won't close the Activity
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
