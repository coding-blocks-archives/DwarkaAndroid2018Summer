package com.codingblocks.taskroom;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TaskDatabase taskDatabase = Room.databaseBuilder(
                this,
                TaskDatabase.class,
                "task_db")
//                .addMigrations(new Migration(1, 3) {
//                    @Override
//                    public void migrate(@NonNull SupportSQLiteDatabase database) {
//
//                    }
//                }, new Migration(2,3) {
//                    @Override
//                    public void migrate(@NonNull SupportSQLiteDatabase database) {
//
//                    }
//                })
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        final TaskDao taskDao = taskDatabase.getTaskDao();

        Button btnInsert = findViewById(R.id.btnInsert);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Insert something to the database
                Task task = new Task("The time is ",
                        String.valueOf(System.currentTimeMillis()),
                        false);

                taskDao.insertTask(task);
            }
        });

//        LiveData<List<Task>> listLiveData =  taskDao.getAllTasks();


//        listLiveData.observe(this, new Observer<List<Task>>() {
//            @Override
//            public void onChanged(@Nullable List<Task> tasks) {
//
//                //Callback with a list of all the tasks
//
//            }
//        });

        MyAndroidViewModel myAndroidViewModel = ViewModelProviders.of(this).get(MyAndroidViewModel.class);

        myAndroidViewModel.getTasksFromDb().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(@Nullable List<Task> tasks) {

            }
        });

        MyViewModel myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);

        myViewModel.getResponseLive().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                
            }
        });

    }
}
