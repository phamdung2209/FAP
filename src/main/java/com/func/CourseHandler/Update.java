package com.func.CourseHandler;

import java.util.Scanner;

import com.course.Course;
import com.persons.Administrator;

public class Update {
    public Scanner scanner = new Scanner(System.in);
    public void updateCourse(Administrator admin, String courseIDUpdate) {
        System.out.print("Course Name: ");
        String uCname = scanner.nextLine();

        System.out.print("Description: ");
        String uCDescription = scanner.nextLine();

        System.out.print("Cost: ");
        Long uCCost = scanner.nextLong();

        Course cour = new Course();
        cour.setCourseName(uCname);
        cour.setDescription(uCDescription);
        cour.setCost(uCCost);

        Administrator administrator = Administrator.getAdministrator();
        administrator.updateCourse(courseIDUpdate, cour);
    }
}
