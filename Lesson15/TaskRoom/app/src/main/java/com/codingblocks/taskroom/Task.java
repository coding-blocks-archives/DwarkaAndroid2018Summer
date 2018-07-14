package com.codingblocks.taskroom;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "task_table")
public class Task {

    private String title, description;

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "task_status")
    private boolean status;

//    @Embedded
//    private SubTask subTask;

    public Task(String title, String description, boolean status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public boolean getStatus() {
        return status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
