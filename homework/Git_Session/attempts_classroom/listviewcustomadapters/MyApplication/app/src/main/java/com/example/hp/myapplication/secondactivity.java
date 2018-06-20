package com.example.hp.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class secondactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        Log.e("TAG", "onCreate: "+" yes");
        Intent i=getIntent();
        String prevuri=i.getDataString();        // it will uri of previous activity
        TextView tv=findViewById(R.id.text);
        tv.setText(prevuri);





//          Intent i=getIntent();
//          String prevuri=i.getDataString();
//          String s=i.getStringExtra("key");
//          TextView tv=findViewById(R.id.Text);
//          tv.setText(prevuri);

    }
}
