package com.springboot.springsec.model;

public class Student {
    private int id;
    private String marks;
    private String name;

    public Student(int id, String marks, String name) {
        this.id = id;
        this.marks = marks;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
