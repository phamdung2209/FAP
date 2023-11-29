package com.date;

import java.util.List;

import com.course.Course;

public class Timetable {
    private int id;
    List<Course> courses;


    public Timetable(int id, List<Course> courses) {
        this.id = id;
        this.courses = courses;
    }

    public Timetable() {
    }

    public int getId() {
        return id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // add  course to timetable
    public void addCourse(Course course) {
        this.courses.add(course);
    }

    // remove course from timetable
    public void removeCourse(Course course) {
        this.courses.remove(course);
    }

    // get course from timetable
    public Course getCourse(int index) {
        return this.courses.get(index);
    }

    // get all courses from timetable
    public List<Course> getAllCourses() {
        return this.courses;
    }

    // // get course schedule from timetable
    public Schedule getCourseSchedule(Course course) {
        return course.getSchedule();
    }
}
