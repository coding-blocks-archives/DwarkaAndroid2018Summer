package com.codingblocks.okhttppost;

public class Student {

    private String password, email;

    public Student(String email, String password) {
        this.password = password;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
