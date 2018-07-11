package com.codingblocks.saveinstancebundle;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        //This check means that my onSaveInstanceState method was called
        if (savedInstanceState != null && savedInstanceState.containsKey("COUNT")) {
            count = savedInstanceState.getInt("COUNT");
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
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("COUNT", count);
        outState.putString("HELLO", "World");
        super.onSaveInstanceState(outState);
    }

    //Called after onCreate is called
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//    }
}
