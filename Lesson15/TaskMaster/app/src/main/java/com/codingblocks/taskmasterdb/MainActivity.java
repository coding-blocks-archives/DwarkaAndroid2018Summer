package com.codingblocks.taskmasterdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TaskDatabase taskDatabase = new TaskDatabase(this);
        Button btnInsert = findViewById(R.id.btnInsert);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Task task = new Task("The time ",
                        "is " + System.currentTimeMillis(),
                        System.currentTimeMillis(),
                        false);

                taskDatabase.insertTask(task);
            }
        });

    }
}
