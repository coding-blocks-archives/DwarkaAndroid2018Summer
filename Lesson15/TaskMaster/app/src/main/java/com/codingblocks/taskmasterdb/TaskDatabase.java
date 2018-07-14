package com.codingblocks.taskmasterdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class TaskDatabase extends SQLiteOpenHelper {

    public TaskDatabase(Context context) {
        super(context, "task-db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE task_table ( " +
                "task_id INTEGER PRIMARY KEY, " +
                "title TEXT, " +
                "description TEXT, " +
                "status INTEGER );";
        sqLiteDatabase.execSQL(createTable);
    }

    void insertTask(Task task) {
        //Insert the task into database
//        String insert = "INSERT INTO task_table VALUES ( $id, $title, );";

//        String insertQuery = "INSERT INTO task_table VALUES (" + id + ", " + title + "," + "....);";
//        getWritableDatabase().execSQL(insertQuery);
//
        ContentValues contentValues = new ContentValues();

        contentValues.put("status", task.getStatus());
        contentValues.put("task_id", task.getId());
        contentValues.put("title", task.getTitle());
        contentValues.put("description", task.getDescription());

        getWritableDatabase().insert("task_table", null, contentValues);

    }

    ArrayList<Task> getAllTasks() {
        //Returns all the stores tasks
        return null;
    }

    Task getTaskWithId(long id) {
        //Returns a task with a provided @id
        return  null;
    }

    void updateTask(Task task) {
        //Updates the task with this provided task
    }

    void deleteTask(Task task) {
        //Deletes the provided task
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Default implementation is to drop all the
        // tables and call onCreate again so that they are recreated.

        //i is the old version
        //i1 is the new version
    }
}
