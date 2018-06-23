package com.codingblocks.heterogeneousrv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Object> myArrrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.rvObjects);
        myArrrayList.add(new ImageUrl("https://randomuser.me/api/portraits/women/70.jpg"));
        myArrrayList.add(new Name("Harshit"));
        myArrrayList.add(new ImageUrl("https://randomuser.me/api/portraits/women/13.jpg"));
        myArrrayList.add(new Name("Naman"));
        myArrrayList.add(new ImageUrl("https://randomuser.me/api/portraits/women/24.jpg"));
        myArrrayList.add(new Name("Ashutosh"));
        myArrrayList.add(new ImageUrl("https://randomuser.me/api/portraits/women/45.jpg"));
        myArrrayList.add(new Name("Anurag"));
        myArrrayList.add(new ImageUrl("https://randomuser.me/api/portraits/women/88.jpg"));
        myArrrayList.add(new Name("Vicky"));
        myArrrayList.add(new ImageUrl("https://randomuser.me/api/portraits/women/44.jpg"));
        myArrrayList.add(new Name("Sambhav"));
        myArrrayList.add(new ImageUrl("https://randomuser.me/api/portraits/women/35.jpg"));
        myArrrayList.add(new Name("Biswaroop"));
        myArrrayList.add(new ImageUrl("https://randomuser.me/api/portraits/women/76.jpg"));
        myArrrayList.add(new Name("Sasha"));

        HeterogeneousAdapter heterogeneousAdapter = new HeterogeneousAdapter(myArrrayList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(heterogeneousAdapter);

    }
}
