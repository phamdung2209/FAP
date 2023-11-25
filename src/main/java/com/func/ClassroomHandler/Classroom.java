package com.func.ClassroomHandler;

public class Classroom {
    private String id = "D";
    private String name;
    private String lecturerId;

    public Classroom() {
    }

    public Classroom(String id, String name, String lecturerId) {
        this.id += id;
        this.name = name;
        this.lecturerId = lecturerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }
}
