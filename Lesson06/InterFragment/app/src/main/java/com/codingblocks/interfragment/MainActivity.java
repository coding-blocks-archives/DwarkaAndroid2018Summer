package com.codingblocks.interfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void doSomething(String name) {

        getSupportFragmentManager().beginTransaction()
                            .add(R.id.container,new FragmentB(name))
                            .commit();

    }
}
