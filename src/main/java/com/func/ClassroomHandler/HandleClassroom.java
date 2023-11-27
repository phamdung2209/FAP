package com.func.ClassroomHandler;

import java.util.Scanner;

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
                    if (!admin.checkStudentInClass(classroomId, studentId)) { // fixxxxxxxxxxx
                        admin.addStudentToClass(classroomId, studentId);
                    }
                }

                break;
            case 5:
                // view classroom
                admin.viewClassroom();
                break;
            case 0:
                System.out.println("Back to main menu");
                break;
            default:
                System.out.println("Invalid input. Please enter a number.");
                break;
        }
    }
}
