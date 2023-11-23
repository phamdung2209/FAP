package com.course;

import java.util.ArrayList;
import java.util.List;

import com.Date.Schedule;
import com.persons.Lecturer;
import com.persons.Student;

public class Course {
    private String id;
    private String courseName;
    private String description;
    private long cost;
    private Student student;
    private Lecturer lecturer;
    private List<Schedule> schedules = new ArrayList<Schedule>();

    public Course() {
    }

    public Course(String id, String courseName, String description, long cost, Student student, Lecturer lecturer) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.cost = cost;
        this.student = student;
        this.lecturer = lecturer;
    }

    public Course(String id, String courseName, String description, long cost) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public void reg() {
    }

    public void cancelReg() {
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", courseName=" + courseName + ", description=" + description + ", cost=" + cost
                + ", student=" + student + ", lecturer=" + lecturer + "]";
    }

    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }

    public void removeSchedule(Schedule schedule) {
        this.schedules.remove(schedule);
    }

    public Schedule getSchedule(int index) {
        return this.schedules.get(index);
    }

    public List<Schedule> getAllSchedules() {
        return this.schedules;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    //getSchedule()
    public Schedule getSchedule() {
        Schedule sch = null;
        for (Schedule schedule : schedules) {
            sch = schedule;
        }
        return sch;
    }
}
