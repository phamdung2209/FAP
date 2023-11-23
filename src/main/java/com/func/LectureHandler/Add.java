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
    public static final String filePath = "C:\\Users\\ACER\\Documents\\Course\\Advance Programming\\Assignment 2\\Project\\FAP\\src\\main\\java\\service\\data.json";
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

        // if (admin.checkLecture(lid)) {
        // System.out.println("Lecture already exists.");
        // } else if (admin.addLecturer(lecturer)) {
        // System.out.println("Lecturer added successfully.");
        // } else {
        // System.out.println("Failed to add lecturer.");
        // }

        if (admin.checkLecture(lid)) {
            System.out.println("Lecture already exists.");
        } else {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                File file = new File(filePath);

                TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
                };
                HashMap<String, Object> data = objectMapper.readValue(file, typeRef);

                List<Map<String, String>> lectures = (List<Map<String, String>>) data.get("lectures");
                if (lectures == null) {
                    lectures = new ArrayList<>();
                }

                Map<String, String> newLecture = new HashMap<>();
                newLecture.put("id", lecturer.getId());
                newLecture.put("name", lecturer.getFullName());
                newLecture.put("address", lecturer.getAddress());
                newLecture.put("gender", String.valueOf(lecturer.getGender()));
                newLecture.put("day", String.valueOf(lecturer.getDateOfBirth().getDay()));
                newLecture.put("month", String.valueOf(lecturer.getDateOfBirth().getMonth()));
                newLecture.put("year", String.valueOf(lecturer.getDateOfBirth().getYear()));
                newLecture.put("phone", lecturer.getPhoneNumber());
                newLecture.put("email", lecturer.getEmail());
                newLecture.put("department", lecturer.getDepartment());

                lectures.add(newLecture);
                data.put("lectures", lectures);

                objectMapper.writeValue(file, data);
                System.out.println("Lecture added successfully.");
            } catch (IOException e) {
                System.err.println("Error reading/writing to file: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
