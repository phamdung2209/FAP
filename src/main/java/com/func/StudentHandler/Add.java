package com.func.StudentHandler;

import java.util.Scanner;
import com.Date.DateOfBirth;
import com.persons.Administrator;
import com.persons.Student;

public class Add {

    public Scanner scanner = new Scanner(System.in);

    public void aS(int option, Administrator admin) {
        // Add student
        System.out.println("Enter student's information:");
        System.out.print("ID: ");
        String id = scanner.next();
        scanner.nextLine();

        System.out.print("Full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Gender: ");
        String genderString = scanner.nextLine();

        DateOfBirth dateOfBirth = new DateOfBirth();
        System.out.print("Date of birth: ");
        int day = scanner.nextInt();
        System.out.print("Month of birth: ");
        int month = scanner.nextInt();
        System.out.print("Year of birth: ");
        int yearDob = scanner.nextInt();
        dateOfBirth.setDay(day);
        dateOfBirth.setMonth(month);
        dateOfBirth.setYear(yearDob);

        System.out.print("Year of admission: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Major: ");
        String major = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("Phone number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        Student student = new Student();
        student.setId("BH00" + id);
        student.setFullName(fullName);
        student.setGender(genderString);
        student.setDateOfBirth(dateOfBirth);
        student.setYear(year);
        student.setMajor(major);
        student.setAddress(address);
        student.setPhoneNumber(phoneNumber);
        student.setEmail(email);

        if (admin.checkStudent("BH00" + id)) {
            System.out.println("Student already exists.");
            // break;
        } else {
            Administrator administrator = new Administrator();
            administrator.addStudent(student);
        }

    }
}
