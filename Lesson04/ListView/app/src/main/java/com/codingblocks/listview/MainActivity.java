package com.codingblocks.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentList.add("Harshit");
        studentList.add("Naman");
        studentList.add("Ashutosh");
        studentList.add("Shlok");
        studentList.add("Omisha");
        studentList.add("Sasha");
        studentList.add("Biswaroop");
        studentList.add("Ansh");
        studentList.add("Sambhav");
        studentList.add("Kapil");
        studentList.add("Aman");
        studentList.add("Anurag");
        studentList.add("Vicky");
        studentList.add("Abha");
        studentList.add("Shivani");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.list_item,
                R.id.studentName,
                studentList);

        final ListView studentListView = findViewById(R.id.listViewStudents);

        studentListView.setAdapter(arrayAdapter);

        studentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("TAG", "onItemClick: " + i);
                String studentName = studentList.get(i);
                Toast.makeText(getBaseContext(),studentName,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
