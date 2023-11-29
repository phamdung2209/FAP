package com.persons;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.course.Course;
import com.date.DateOfBirth;
import com.func.Grade;
import com.func.View;
import com.persons.personType.PersonType;

public class Lecturer extends User {
    private static final Lecturer getLecturer = new Lecturer();
    private String department;

    private Lecturer() {
    }

    public static Lecturer getLecturer() {
        return getLecturer;
    }

    // person type
    public PersonType getPersonType() {
        return PersonType.LECTURER;
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
