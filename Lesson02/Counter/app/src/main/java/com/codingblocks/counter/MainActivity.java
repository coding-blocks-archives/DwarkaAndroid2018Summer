package com.codingblocks.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int counter = 0;
    TextView currentCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentCount = findViewById(R.id.textView);
        Log.e("TAG", "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("TAG", "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG", "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("TAG", "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TAG", "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "onDestroy:");

    }

    public void increment(View view) {
        counter++;
        Log.e("TAG", "increment: " + counter);
        currentCount.setText(String.valueOf(counter));
    }

    public void decrement(View view) {

//        switch (view.getId()){
//            case R.id.buttonIncrement:
//                counter++;
//                break;
//            case R.id.buttonDecrement :
//                counter--;
//                break;
//            case R.id.btnReset:
//                counter = 0;
//                break;
//            default:
//                Log.e("TAG", "decrement: Wrong Input");
//        }
        counter--;
        Log.e("TAG", "decrement: " + counter);
        currentCount.setText(String.valueOf(counter));
    }

    public void reset(View view) {
        counter = 0;
        Log.e("TAG", "reset: " + counter);
        currentCount.setText(String.valueOf(0));
    }
}
