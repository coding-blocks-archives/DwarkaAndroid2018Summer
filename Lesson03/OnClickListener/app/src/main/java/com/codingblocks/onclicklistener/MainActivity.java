package com.codingblocks.onclicklistener;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.SupportActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = findViewById(R.id.btnTest);

//        View.OnClickListener onClickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        };
        MyOnClickListener m = new MyOnClickListener(this);

        b.setOnClickListener(m);
        final Context ctx = this;

        //Creates an object of an anonymous inner class that implements the OnClickListener Interface
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ctx,"Hello I'm a Toast",Toast.LENGTH_SHORT).show();

            }
        });

        Button btnTest2 = findViewById(R.id.btnTest2);

        btnTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Handle click for second button here
            }
        });


        TextView btnTest3 = findViewById(R.id.btnTest3);

        btnTest3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Hello I'm a TextView",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
