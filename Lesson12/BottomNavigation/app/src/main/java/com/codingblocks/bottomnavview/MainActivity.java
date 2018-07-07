package com.codingblocks.bottomnavview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btn);
        Button button2 = findViewById(R.id.btn2);
        TextView textView = findViewById(R.id.message);

//        View.OnClickListener onClickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        };
//
//        button.setOnClickListener(onClickListener);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        textView.setOnClickListener(this);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        //Handle Home
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.navigation_dashboard:
                        //Handle Dashboard
                        Toast.makeText(MainActivity.this, "Dashboard", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.navigation_notifications:
                        //Handle notifications
                        Toast.makeText(MainActivity.this, "Notifications", Toast.LENGTH_SHORT).show();
                        return true;
                }
                //Return true to highlight the icon, otherwise return false
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        //Handle the clicks here
        switch (v.getId()){
            case  R.id.btn :
                //Handle first button click
                break;
            case R.id.btn2:
                //Handle second button click
                break;
            case R.id.message:
                //Handle textView click
                break;
        }
    }
}
