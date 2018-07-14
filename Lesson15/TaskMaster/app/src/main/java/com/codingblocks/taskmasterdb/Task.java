package com.codingblocks.taskmasterdb;

public class Task {

    private String title, description;
    private long id;
    private boolean status;

    public Task(String title, String description, long id, boolean status) {
        this.title = title;
        this.description = description;
        this.id = id;
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
}
