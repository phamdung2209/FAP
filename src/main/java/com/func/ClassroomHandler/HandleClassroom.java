package com.func.ClassroomHandler;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.func.BackToMain;
import com.persons.Administrator;

public class HandleClassroom {
    public Scanner scanner = new Scanner(System.in);

    public void processClassroom(int option, Administrator admin) {
        switch (option) {
            case 1:
                System.out.println("Enter classroom's information:");
                System.out.print("Enter classroom's ID: ");
                String id = scanner.nextLine();

                System.out.print("Enter classroom's name: ");
                String name = scanner.nextLine();

                System.out.print("Enter homeroom lecturer ID: ");
                String lecturerId = scanner.nextLine();

                if (admin.checkClassroom("D" + id)) {
                    System.out.println("Classroom already exists.");
                    break;
                } else {
                    Classroom classroom = new Classroom(id, name, lecturerId);
                    admin.addClassroom(classroom);
                }
                break;
            case 2:
                System.out.println("Add students to the classroom:");
                System.out.print("Enter classroom's ID: ");
                String classroomId = scanner.nextLine();

                System.out.print("Enter student's ID: ");
                String studentId = scanner.nextLine();

                if (!admin.checkClassroom(classroomId)) {
                    System.out.println("Classroom does not exist.");
                } else if (!admin.checkStudent(studentId)) {
                    System.out.println("Student does not exist.");
                } else {
                    if (!admin.checkStudentInClass(classroomId, studentId)) {
                        admin.addStudentToClass(classroomId, studentId);
                    } else {
                        System.out.println("Student already in class.");
                    }
                }

                break;
            case 3:
                System.out.println("Remove students from the classroom:");
                System.out.print("Enter classroom's ID: ");
                String classroomIdRemove = scanner.nextLine();

                if (admin.checkClassroom(classroomIdRemove)) {
                    System.out.print("Are you sure you want to delete this course? (y/n) ");
                    String confirm = scanner.next();

                    switch (confirm) {
                        case "y":
                        case "yes":
                        case "Y":
                            System.out.println("Deleting classroom...");
                            new Timer().schedule(new TimerTask() {
                                public void run() {
                                    admin.deleteClass(classroomIdRemove);
                                }
                            }, 3000);
                            break;
                        case "n":
                        case "no":
                        case "N":
                        case "":
                            System.out.println("Canceled!");
                            break;
                        default:
                            break;
                    }

                } else {
                    System.out.println("Classroom does not exist.");
                }
                break;
            case 4:
                // view classroom
                admin.viewClassroom();
                break;
            case 5:
                // get classroom information
                System.out.print("Enter classroom's ID: ");
                String classroomIdGet = scanner.nextLine();

                if (admin.checkClassroom(classroomIdGet)) {
                    admin.getClassroom(classroomIdGet);
                } else {
                    System.out.println("Classroom does not exist.");
                }
                break;
            case 0:
                BackToMain backToMain = new BackToMain();
                backToMain.backToMain();
                break;
            default:
                System.out.println("Invalid input. Please enter a number.");
                break;
        }
    }
}
