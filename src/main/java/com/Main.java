package com;

import java.sql.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.func.BackToMain;
import com.func.ClassroomHandler.HandleClassroom;
import com.func.CourseHandler.HandleCourse;
import com.func.GradeHandler.HandleGrade;
import com.func.LectureHandler.HandleLecture;
import com.func.StudentHandler.HandleStudent;
import com.persons.Administrator;
import com.persons.User;
import com.persons.personType.PersonType;

public class Main {
    public static void main(String[] args) {
        // singleton pattern
        // Administrator admin = Administrator.getAdministrator();

        // use factory method to create admin
        Administrator admin = (Administrator) User.getUser(PersonType.ADMINISTRATOR);

        Scanner scanner = new Scanner(System.in);

        BackToMain backToMain = new BackToMain();
        backToMain.backToMain();

        int option = -1;
        while (option != 0) {
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("------MANAGE STUDENT-----");
                        System.out.println("1. Add student");
                        System.out.println("2. Update student");
                        System.out.println("3. Delete student");
                        System.out.println("4. View student");
                        System.out.println("0. Back");
                        System.out.println("-------------------------");
                        System.out.print("Choose your option: ");

                        int studentOption = -1;
                        while (studentOption != 0) {
                            if (scanner.hasNextInt()) {
                                studentOption = scanner.nextInt();
                                HandleStudent handleStudent = new HandleStudent();
                                handleStudent.processStudent(studentOption, admin);
                            } else {
                                System.out.println("Invalid input. Please enter a number.");
                                scanner.next();
                            }
                        }
                        break;
                    case 2:
                        System.out.println("------MANAGE LECTURE-----");
                        System.out.println("1. Add lecture");
                        System.out.println("2. Update lecture");
                        System.out.println("3. Delete lecture");
                        System.out.println("4. View lecture");
                        System.out.println("0. Back");
                        System.out.println("-------------------------");
                        System.out.print("Choose your option: ");

                        int lectureOption = -1;
                        while (lectureOption != 0) {
                            if (scanner.hasNextInt()) {
                                lectureOption = scanner.nextInt();
                                HandleLecture handleLecture = new HandleLecture();
                                handleLecture.processLecture(lectureOption, admin);
                            }
                        }

                        break;
                    case 3:
                        System.out.println("------MANAGE COURSE-----");
                        System.out.println("1. Add course");
                        System.out.println("2. Update course");
                        System.out.println("3. Delete course");
                        System.out.println("4. View course");
                        System.out.println("0. Back");
                        System.out.println("-------------------------");
                        System.out.print("Choose your option: ");

                        int courseOption = -1;
                        while (courseOption != 0) {
                            if (scanner.hasNextInt()) {
                                courseOption = scanner.nextInt();
                                HandleCourse handleCourse = new HandleCourse();
                                handleCourse.processCourse(courseOption, admin);
                            }
                        }
                        break;
                    case 4:
                        System.out.println("------MANAGE GRADE-----");
                        System.out.println("1. Add grade");
                        System.out.println("2. Update grade");
                        System.out.println("3. Delete grade");
                        System.out.println("4. View grade");
                        System.out.println("0. Back");
                        System.out.println("-------------------------");
                        System.out.print("Choose your option: ");

                        int gradeOption = -1;
                        while (gradeOption != 0) {
                            if (scanner.hasNextInt()) {
                                gradeOption = scanner.nextInt();

                                HandleGrade handleGrade = new HandleGrade();
                                handleGrade.processGrade(admin, gradeOption);
                            }
                        }
                        break;
                    case 5:
                        System.out.println("------MANAGE CLASSROOM-----");
                        System.out.println("1. Add classroom");
                        System.out.println("2. Add student to classroom");
                        System.out.println("3. Delete classroom");
                        System.out.println("4. Get classroom information");
                        System.out.println("5. Get student list in classroom");
                        System.out.println("0. Back");
                        System.out.println("-------------------------");
                        System.out.print("Choose your option: ");

                        int classroomOption = -1;
                        while (classroomOption != 0) {
                            if (scanner.hasNextInt()) {
                                classroomOption = scanner.nextInt();
                                HandleClassroom handleClassroom = new HandleClassroom();
                                handleClassroom.processClassroom(classroomOption, admin);
                            }
                        }
                        break;
                    case 0:
                        System.out.println("System is stopping...");
                        new Timer().schedule((new TimerTask() {
                            public void run() {
                                System.out.println("Bye\nSystem stopped.");
                                System.exit(0);
                            }
                        }), 2000);
                        break;
                    default:
                        System.out.println("Invalid option. Please choose a valid option.");
                }
            } else {
                // If the input is not an integer, clear the buffer
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        scanner.close();
    }
}
