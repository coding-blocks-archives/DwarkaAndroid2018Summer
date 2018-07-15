package com.codingblocks.taskroom;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

public class MyAndroidViewModel extends AndroidViewModel {
    private final TaskDatabase taskDatabase;
    private LiveData<List<Task>> listLiveData;

    public MyAndroidViewModel(@NonNull Application application) {
        super(application);

        Context context = application.getApplicationContext();
        taskDatabase = Room.databaseBuilder(
                context,
                TaskDatabase.class,
                "task_db")
                .allowMainThreadQueries()
                .build();
    }

    LiveData<List<Task>> getTasksFromDb() {
        if (listLiveData == null) {
            listLiveData = taskDatabase.getTaskDao().getAllTasks();
        }
        return listLiveData;
    }

}
