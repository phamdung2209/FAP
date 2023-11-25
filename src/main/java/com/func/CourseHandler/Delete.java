package com.func.CourseHandler;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.persons.Administrator;

public class Delete {
    public Scanner scanner = new Scanner(System.in);

    public void deleteCourse(Administrator admin) {
        System.out.print("Enter course's ID: ");
        String courseID = scanner.next();
        if (!admin.checkCourse(courseID)) {
            System.out.println("Course does not exist.");
        } else {
            System.out.print("Are you sure you want to delete this course? (y/n) ");
            String confirm = scanner.next();
            switch (confirm) {
                case "Y":
                case "y":
                    System.out.println("Deleting course...");
                    if (admin.deleteCourse(courseID)) {
                        new Timer().schedule(new TimerTask() {
                            public void run() {
                                admin.deleteCourse(courseID);
                                System.out.println("Course deleted successfully.");
                            }
                        }, 3000);
                    } else {
                        System.out.println("Failed to delete course.");
                    }
                    break;
                case "N":
                case "n":
                    System.out.println("Canceling...");
                    break;
                default:
                    System.out.println("Invalid input. Please enter Y or N.");
                    break;
            }
        }
    }
}
