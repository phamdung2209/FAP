package com.persons;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import com.date.DateOfBirth;
import com.func.Grade;
import com.persons.personType.PersonType;

public class Student extends User implements GradeObserver, Observer{

    // observer pattern
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Grade) {
            System.out.println(name + " received grade update: " + arg);
        }
    }

    @Override
    public void updateGrade(String newGrade) {
        Administrator.getAdministrator().updateGrade(newGrade);
    }
    
    // end observer pattern

    private static final Student getStudent = new Student();
    private String major;
    private int year;

    private Student() {
    }

    public static Student getStudent() {
        return getStudent;
    }

    // person type
    public PersonType getPersonType() {
        return PersonType.STUDENT;
    }

    public Student(String id, String fullName, DateOfBirth dateOfBirth, genderType gender, String address,
            String phoneNumber, String email, String major, int year) {
        super(id, fullName, dateOfBirth, gender, address, phoneNumber, email);
        this.major = major;
        this.year = year;
    }

    public Student(String major, int year) {
        this.major = major;
        this.year = year;
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

    @Override
    public void viewCourse() {
        Administrator.getAdministrator().viewCourse();
    }

    @Override
    public void viewGrade() {
        Administrator.getAdministrator().viewGrade();
    }

    @Override
    public void viewTimetable() {
        Administrator.getAdministrator().viewTimetable();
    }

    @Override
    public void viewClass() {
        Administrator.getAdministrator().viewClassroom();
    }

    // feedback
    public void feedback(Lecturer lecturer) {
        // array list save feedback
        List<String> feedbacks = new ArrayList<String>();
        if (lecturer != null) {
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
