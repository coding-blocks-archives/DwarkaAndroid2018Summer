package com.codingblocks.firebase;

public class Task {


    //Don't proguard these files otherwise firebase won't be able to map
    //your data
    long id;
    String title;
    String subtitle;

    public Task() {
    }

    public Task(long id, String title, String subtitle) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
