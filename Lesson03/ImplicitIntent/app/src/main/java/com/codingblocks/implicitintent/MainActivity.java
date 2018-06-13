package com.codingblocks.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnOpenBrowser = findViewById(R.id.btnOpenBrowser);

        btnOpenBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent();
                i.setAction("harshit.dwivedi");
                i.putExtra("hello","world");
//                i.setData(Uri.parse("https://www.google.com"));
                startActivity(i);
            }
        });

    }
}
