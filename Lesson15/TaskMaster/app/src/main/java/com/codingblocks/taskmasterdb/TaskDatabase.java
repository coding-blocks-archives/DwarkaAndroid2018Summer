package com.codingblocks.taskmasterdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.codingblocks.taskmasterdb.Constants.*;

import java.util.ArrayList;
import java.util.TimerTask;

public class TaskDatabase extends SQLiteOpenHelper {

    public TaskDatabase(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " ( " +
                COLUMN_ID + " INTEGER PRIMARY KEY, " +
                COLUMN_TITLE + " TEXT NOT NULL, " +
                COLUMN_DESC + " TEXT, " +
                COLUMN_STATUS + " INTEGER );";
        sqLiteDatabase.execSQL(createTable);
    }

    void insertTask(Task task) {
        //Insert the task into database
//        String insert = "INSERT INTO task_table VALUES ( $id, $title, );";

//        String insertQuery = "INSERT INTO task_table VALUES (" + id + ", " + title + "," + "....);";
//        getWritableDatabase().execSQL(insertQuery);
//
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_STATUS, task.getStatus());
        contentValues.put(COLUMN_ID, task.getId());
        contentValues.put(COLUMN_TITLE, task.getTitle());
        contentValues.put(COLUMN_DESC, task.getDescription());

        getWritableDatabase().insert(TABLE_NAME, null, contentValues);

    }

    ArrayList<Task> getAllTasks() {
        //Returns all the stores tasks

        ArrayList<Task> tasks = new ArrayList<>();
        Cursor cursor = getReadableDatabase().query(
                TABLE_NAME,
//                new String[]{COLUMN_ID, COLUMN_DESC, COLUMN_STATUS, COLUMN_TITLE},
//                COLUMN_ID + " > ? AND status = ?",
//                new String[]{String.valueOf(5), String.valueOf(0)},
                null,
                null,
                null,
                null,
                null,
                null
        );

        while (cursor.moveToNext()) {
            long id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID));
            String title = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE));
            String desc = cursor.getString(cursor.getColumnIndex(COLUMN_DESC));
            boolean status;
//            status = cursor.getInt(cursor.getColumnIndex(COLUMN_STATUS)) == 1;
            if (cursor.getInt(cursor.getColumnIndex(COLUMN_STATUS)) == 1) {
                status = true;
            } else
                status = false;

            Task task = new Task(title, desc, id, status);
            tasks.add(task);
        }
        cursor.close();
        return tasks;
    }

    Task getTaskWithId(long id) {
        //Returns a task with a provided @id
        return null;
    }

    void updateTask(Task task) {
        //Updates the task with this provided task
//        getWritableDatabase().update()
    }

    void deleteTask(Task task) {
        //Deletes the provided task
        getWritableDatabase().delete(TABLE_NAME,
                COLUMN_ID + " = ?",
                new String[]{String.valueOf(task.getId())});
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Default implementation is to drop all the
        // tables and call onCreate again so that they are recreated.

        //i is the old version
        //i1 is the new version
    }
}
