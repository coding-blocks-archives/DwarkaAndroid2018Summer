package com.codingblocks.taskroom;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.List;

@Dao
public interface TaskDao {

//    @Query("DROP TABLE task_table")
//    void deleteTable();

    @Insert
    void insertTask(Task task);

    @Insert
    void insertMultipleTasks(Task... tasks);

    @Delete
    void deleteTask(Task task);

    @Update
    void updateTask(Task task);

    @Query("SELECT * FROM task_table")
    //Wrapping anything inside a LiveData makes it an observable
    //meaning you can observe it for changes
    LiveData<List<Task>> getAllTasks();

    @Query("SELECT * FROM task_table WHERE id = :id")
    Task getTaskWithId(long id);

}
