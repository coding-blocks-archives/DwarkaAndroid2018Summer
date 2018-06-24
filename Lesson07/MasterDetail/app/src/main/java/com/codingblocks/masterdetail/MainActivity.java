package com.codingblocks.masterdetail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void doSomething() {
        FrameLayout container = findViewById(R.id.container);
        if (container == null) {
            //Portait mode
            Intent i = new Intent(this, DetailActivity.class);
            startActivity(i);
        } else {
            //Landscape mode
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new FragmentB())
                    .commit();
        }

    }
}
