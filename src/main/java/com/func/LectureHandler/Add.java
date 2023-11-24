package com.func.LectureHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.Date.DateOfBirth;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.persons.Administrator;
import com.persons.Lecturer;

public class Add {
    public Scanner scanner = new Scanner(System.in);

    public void addLecture(Administrator admin) {
        System.out.println("Enter lecture's information:");
        System.out.print("ID: ");
        String lid = scanner.next();
        scanner.nextLine();

        System.out.print("Full name: ");
        String lname = scanner.nextLine();
        
        System.out.print("Gender: ");
        String lgender = scanner.nextLine();
        
        System.out.print("Date of birth: ");
        int lday = scanner.nextInt();
        System.out.print("Month of birth: ");
        int lmonth = scanner.nextInt();
        System.out.print("Year of birth: ");
        int lyear = scanner.nextInt();
        DateOfBirth ldateOfBirth = new DateOfBirth();
        ldateOfBirth.setDay(lday);
        ldateOfBirth.setMonth(lmonth);
        ldateOfBirth.setYear(lyear);
        scanner.nextLine();


        System.out.print("Address: ");
        String laddress = scanner.nextLine();

        System.out.print("Phone number: ");
        String lphoneNumber = scanner.nextLine();

        System.out.print("Email: ");
        String lemail = scanner.nextLine();

        System.out.print("Department: ");
        String ldepartment = scanner.nextLine();

        Lecturer lecturer = new Lecturer();
        lecturer.setId(lid);
        lecturer.setFullName(lname);
        lecturer.setDateOfBirth(ldateOfBirth);
        lecturer.setGender(lgender);
        lecturer.setAddress(laddress);
        lecturer.setPhoneNumber(lphoneNumber);
        lecturer.setEmail(lemail);
        lecturer.setDepartment(ldepartment);

        if (admin.checkLecture(lid)) {
            System.out.println("Lecture already exists!");
        } else {
            Administrator administrator = new Administrator();
            administrator.addLecturer(lecturer);
        }
    }
}
