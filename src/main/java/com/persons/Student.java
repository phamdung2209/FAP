package com.persons;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Date.DateOfBirth;
import com.course.Course;
import com.func.Grade;
import com.func.View;

public class Student extends User implements View {
    private String major;
    private int year;
    User user;
    List<Course> courses;

    public Student(String id, String fullName, DateOfBirth dateOfBirth, genderType gender, String address,
            String phoneNumber, String email, String major, int year, User user, List<Course> courses) {
        super(id, fullName, dateOfBirth, gender, address, phoneNumber, email);
        this.major = major;
        this.year = year;
        this.user = user;
        this.courses = courses;
    }

    public Student() {
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public void viewCourse() {
        new Administrator().viewCourse();
    }

    @Override
    public void viewGrade() {

    }

    @Override
    public void viewTimetable() {
        //
    }

    @Override
    public void viewClass() {
        //
    }

    @Override
    public String toString() {
        return "Student [major=" + major + ", year=" + year + ", user=" + user + ", courses=" + courses + "]";
    }

    // feedback
    public void feedback(Lecturer lecturer) {
        // array list save feedback
        List<String> feedbacks = new ArrayList<String>();
        if(lecturer != null){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Feedback for lecturer: " + lecturer.getFullName());
            System.out.println("Enter feedback: ");
            String feedback = scanner.nextLine();
            feedbacks.add(feedback);
            System.out.println("Feedback sent!");
            scanner.close();
        } else {
            System.out.println("Lecturer not found!");
        }
    }
}
