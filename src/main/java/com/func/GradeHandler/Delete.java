package com.func.GradeHandler;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.persons.Administrator;

public class Delete {
    public Scanner scanner = new Scanner(System.in);

    public void deleteGrade(Administrator admin) {
        System.out.print("Enter grade's ID: ");
        String studentId = scanner.next();
        if (!admin.checkGrade(studentId)) {
            System.out.println("Grade does not exist.");
        } else {
            System.out.print("Are you sure you want to delete this grade? (y/n) ");
            String confirm = scanner.next();
            switch (confirm) {
                case "Y":
                case "y":
                case "":
                    System.out.println("Deleting grade...");
                    if (admin.deleteGrade(studentId)) {
                        new Timer().schedule(new TimerTask() {
                            public void run() {
                                admin.deleteGrade(studentId);
                                System.out.println("Grade deleted successfully.");
                            }
                        }, 3000);
                    } else {
                        System.out.println("Failed to delete grade.");
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
