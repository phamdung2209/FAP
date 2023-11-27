package com.func.CourseHandler;

import java.util.Scanner;

import com.course.Course;
import com.persons.Administrator;

public class Add {
    Scanner scanner = new Scanner(System.in);

    public void addCourse(Administrator admin) {
        System.out.println("Enter course's information:");
        System.out.print("ID: ");
        String cid = scanner.next();
        scanner.nextLine();

        System.out.print("Course Name: ");
        String cname = scanner.nextLine();

        System.out.print("Description: ");
        String cDescription = scanner.nextLine();

        System.out.print("Cost: ");
        Long cCost = scanner.nextLong();

        // System.out.print("Lecturer: ");
        // String clecturer = scanner.nextLine();

        Course course = new Course(cid, cname, cDescription, cCost);

        if (admin.checkCourse(cid)) {
            System.out.println("Course already exists.");
        } else {
            Administrator administrator = Administrator.getAdministrator();
            administrator.addCourse(course);
        }
    }
}
