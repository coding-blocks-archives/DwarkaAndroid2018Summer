package com.codingblocks.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnCount;
    TextView tvCount;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCount = findViewById(R.id.btnCount);
        tvCount = findViewById(R.id.tvCount);
        SharedPreferences preferences = getSharedPreferences("my_prefs_file", MODE_PRIVATE);

        preferences.getAll();

        if (preferences.contains("COUNT")) {
            count = preferences.getInt("COUNT", 0);
            tvCount.setText(String.valueOf(count));
        }

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                tvCount.setText(String.valueOf(count));
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences = getSharedPreferences("my_prefs_file", MODE_PRIVATE);
        SharedPreferences.Editor sharedPrefsEditor = sharedPreferences.edit();

        sharedPrefsEditor.putInt("COUNT", count);

        //Apply saves the data asynchronously in a separate thread
        //Commit saves the data synchronously on the main thread
        sharedPrefsEditor.apply();
    }
}
