package com.func.StudentHandler;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.Date.DateOfBirth;
import com.func.BackToMain;
import com.persons.Administrator;
import com.persons.Student;

public class HandleStudent {
    public Scanner scanner = new Scanner(System.in);

    public void processStudent(int option, Administrator admin) {
        switch (option) {
            case 1:
                // Add student
                Add aS = new Add();
                aS.aS(option, admin);
                break;
            case 2:
                // Update student
                System.out.print("Enter student's ID: ");
                String studentIdUpdate = scanner.next();
                scanner.nextLine();

                if (admin.checkStudent(studentIdUpdate) == false) {
                    System.out.println("Student does not exist.");
                    break;
                } else {
                    Update uS = new Update();
                    uS.updateStudent(admin, studentIdUpdate);

                    break;
                }
            case 3:
                Delete dS = new Delete();
                dS.deleteStudent(admin);
                break;
            case 4:
                // View student
                View view = new View();
                view.viewStudent(admin);
                break;
            case 0:
                System.out.println("Back to main menu...");
                BackToMain backToMain = new BackToMain();
                backToMain.backToMain();
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }
}
