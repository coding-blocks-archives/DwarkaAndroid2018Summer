package com.example.hp.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.Inet4Address;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          Button ref=findViewById(R.id.button);
          ref.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent i=new Intent();
                  i.setAction(Intent.ACTION_VIEW);
                  i.setData(Uri.parse("https://www.facebook.com"));
                  i.putExtra("key","https://www.google.com");
                  startActivity(i);
              }
          });

//
//        android.util.Log.e("TAG", "onCreate: ");
//
//        final Context ct = this;
//        Button bt = findViewById(R.id.button);
//        final EditText et = findViewById(R.id.editText);
//
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public v3oid onClick(View view) {
//                String s = et.getText().toString();
//                Intent i = new Intent(ct, secondactivity.class);
//                i.putExtra("key", s);
//                startActivity(i);
//                finish();
//            }
//
//
//        });
//
//        Button bt=findViewById(R.id.button);
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i =new Intent();
//                i.setAction("naman.kathuria");
//               // i.putExtra("hello","world");
//                i.setData(Uri.parse("https://www.google.com"));
//                startActivity(i);
//
//
//            }
//        });
    }
}


