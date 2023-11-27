package com.persons;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Date.DateOfBirth;
import com.course.Course;
import com.func.Grade;
import com.func.View;

public class Lecturer extends User implements View {
    private String department;

    public Lecturer() {
    }

    public Lecturer(String id, String fullName, DateOfBirth dateOfBirth, genderType gender, String address,
            String phoneNumber, String email, String department) {
        super(id, fullName, dateOfBirth, gender, address, phoneNumber, email);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void viewCourse() {
        // view course
        Administrator.getAdministrator().viewCourse();
    }

    @Override
    public void viewGrade() {
        // view grade
        // List<Grade> grades = new ArrayList<>();
        // grades.forEach((grade) -> {
        // System.out.format("%-10s %-15s %-15s %-10s %-10s %-15s %-20s %-15s %-5s\n",
        // grade.getStudent().getId(), grade.getStudent().getFullName(),
        // grade.getStudent().getDateOfBirth().getDay() + "/" +
        // grade.getStudent().getDateOfBirth().getMonth() + "/"
        // + grade.getStudent().getDateOfBirth().getYear(),
        // grade.getStudent().getGender(), grade.getStudent().getAddress(),
        // grade.getStudent().getPhoneNumber(), grade.getStudent().getEmail(),
        // grade.getStudent().getMajor(), grade.getStudent().getYear() + "\n");
        // });

    }

    @Override
    public void viewTimetable() {
        //
    }

    @Override
    public void viewClass() {
        //
    }

    public int gradeStudent(Student student, Lecturer lecturer, Course course, int gradeAsm) {
        List<Grade> grades = new ArrayList<>();
        Grade grade = new Grade(student, lecturer, course, 80);
        grades.add(grade);
        return grade.getGradeAsm();
    }

    // Attendaces for students
    public void attendances(Student student) {
        // array list save attendances
        List<String> attendances = new ArrayList<String>();
        if (student != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Attendances for student: " + student.getFullName());
            System.out.println("Enter attendances: ");
            String attendance = scanner.nextLine();
            attendances.add(attendance);
            scanner.close();
        }
    }
}
