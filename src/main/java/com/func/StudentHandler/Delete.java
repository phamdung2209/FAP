package com.func.StudentHandler;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.persons.Administrator;

public class Delete {
    public Scanner scanner = new Scanner(System.in);

    public void deleteStudent(Administrator admin) {
        System.out.print("Enter student's ID: ");
        String studentId = scanner.next();
        if (admin.checkStudent(studentId) == false) {
            System.out.println("Student does not exist.");
            // break;
        } else {
            System.out.print("Are you sure you want to delete this student? (y/n) ");
            String confirm = scanner.next();
            switch (confirm) {
                case "Y":
                case "y":
                case "":
                    System.out.println("Deleting student...");
                    if (admin.deleteStudent(studentId)) {
                        new Timer().schedule(new TimerTask() {
                            public void run() {
                                admin.deleteStudent(studentId);
                                System.out.println("Student deleted successfully.");
                            }
                        }, 3000);
                    } else {
                        System.out.println("Failed to delete student.");
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
