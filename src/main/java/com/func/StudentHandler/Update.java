package com.func.StudentHandler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.Date.DateOfBirth;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.persons.Administrator;
import com.persons.Student;

public class Update {
    public static final String filePath = "C:\\Users\\ACER\\Documents\\Course\\Advance Programming\\Assignment 2\\Project\\FAP\\src\\main\\java\\service\\data.json";

    public Scanner scanner = new Scanner(System.in);

    public void updateStudent(Administrator admin, String studentIdUpdate) {
        System.out.print("Full name: ");
        String ufullName = scanner.nextLine();

        System.out.print("Gender: ");
        String ugenderString = scanner.nextLine();

        DateOfBirth udateOfBirth = new DateOfBirth();
        System.out.print("Date of birth: ");
        int uday = scanner.nextInt();
        System.out.print("Month of birth: ");
        int umonth = scanner.nextInt();
        System.out.print("Year of birth: ");
        int uyearDob = scanner.nextInt();
        udateOfBirth.setDay(uday);
        udateOfBirth.setMonth(umonth);
        udateOfBirth.setYear(uyearDob);

        System.out.print("Year of admission: ");
        int uyear = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Major: ");
        String umajor = scanner.nextLine();

        System.out.print("Address: ");
        String uaddress = scanner.nextLine();

        System.out.print("Phone number: ");
        String uphoneNumber = scanner.nextLine();

        System.out.print("Email: ");
        String uemail = scanner.nextLine();

        Student student1 = new Student();
        student1.setFullName(ufullName);
        student1.setGender(ugenderString);
        student1.setDateOfBirth(udateOfBirth);
        student1.setYear(uyear);
        student1.setMajor(umajor);
        student1.setAddress(uaddress);
        student1.setPhoneNumber(uphoneNumber);
        student1.setEmail(uemail);
        
        Administrator administrator = new Administrator();
        administrator.updateStudent(studentIdUpdate, student1);
    }
}
