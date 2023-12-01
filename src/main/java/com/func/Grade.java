package com.func;

import java.util.Observable;

import com.course.Course;
import com.persons.Lecturer;
import com.persons.Student;

public class Grade extends Observable {

    // observer pattern
    private String currentGrade;

    public void updateGrade(String newGrade) {
        this.currentGrade = newGrade;
        setChanged();
        notifyObservers(newGrade);
    }

    public String getCurrentGrade() {
        return currentGrade;
    }

    // end observer pattern

    private int id = 100;
    private Student student;
    private Lecturer lecturer;
    private Course course;
    private int gradeAsm;

    public Grade() {
    }

    public Grade(Student student, Lecturer lecturer, Course course, int gradeAsm) {
        this.id += 1;
        this.student = student;
        this.lecturer = lecturer;
        this.gradeAsm = gradeAsm;
        this.course = course;
        course.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getGradeAsm() {
        return gradeAsm;
    }

    public void setGradeAsm(int gradeAsm) {
        this.gradeAsm = gradeAsm;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Grade [id=" + id + ", student=" + student + ", lecturer=" + lecturer + ", course=" + course
                + ", gradeAsm=" + gradeAsm + "]";
    }

}
