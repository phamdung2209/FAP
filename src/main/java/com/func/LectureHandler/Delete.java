package com.func.LectureHandler;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.persons.Administrator;

public class Delete {
    public Scanner scanner = new Scanner(System.in);

    public void deleteLecture(Administrator admin) {
        System.out.print("Enter lecture's ID: ");
        String lectureId = scanner.next();
        if (!admin.checkLecture(lectureId)) {
            System.out.println("Lecture does not exist.");
        } else {
            System.out.print("Are you sure you want to delete this lecture? (y/n) ");
            String confirm = scanner.next();
            switch (confirm) {
                case "Y":
                case "y":
                    System.out.println("Deleting lecture...");
                    if (admin.deleteLecture(lectureId)) {
                        new Timer().schedule(new TimerTask() {
                            public void run() {
                                admin.deleteLecture(lectureId);
                                System.out.println("Lecture deleted successfully.");
                            }
                        }, 3000);
                    } else {
                        System.out.println("Failed to delete lecture.");
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
