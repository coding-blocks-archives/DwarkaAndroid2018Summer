package com.codingblocks.recyclerview;

public class Student{

    public Student(String name, String batch, String number, String location) {
        this.name = name;
        this.batch = batch;
        this.number = number;
        this.location = location;
    }

    private String name,batch,number,location;

    public String getName() {
        return name;
    }

//    public String getOrModifyName(String s){
//        if (s.equals("")){
//            return name;
//        }
//        else{
//            name = s;
//            return name;
//        }
//    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
