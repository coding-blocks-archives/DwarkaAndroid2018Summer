package com.codingblocks.interfragmentcommunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    void startFragmentB(){
//        FragmentB fragmentB = new FragmentB();
//
//        Bundle bundle = new Bundle();
//        bundle.putString("KEY",name);
//
//        fragmentB.setArguments(bundle);
//
//    }

    @Override
    public void doSomething(String name) {

//        FragmentB fragmentB = new FragmentB();
//
//        Bundle bundle = new Bundle();
//        bundle.putString("KEY",name);
//
//        fragmentB.setArguments(bundle);

        FragmentB fragmentB = FragmentB.newFragment(name);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragmentB)
                .commit();
    }
}
