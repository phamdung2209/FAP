package com.func.LectureHandler;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.Date.DateOfBirth;
import com.persons.Administrator;
import com.persons.Lecturer;

public class HandleLecture {
    public Scanner scanner = new Scanner(System.in);

    public void processLecture(int lectureOption, Administrator admin) {
        switch (lectureOption) {
            case 1:
                // System.out.println("Enter lecture's information:");
                // System.out.print("ID: ");
                // String lid = scanner.next();
                // scanner.nextLine();

                // System.out.print("Full name: ");
                // String lname = scanner.nextLine();

                // System.out.print("Date of birth: ");
                // int lday = scanner.nextInt();
                // System.out.print("Month of birth: ");
                // int lmonth = scanner.nextInt();
                // System.out.print("Year of birth: ");
                // int lyear = scanner.nextInt();
                // DateOfBirth ldateOfBirth = new DateOfBirth();
                // ldateOfBirth.setDay(lday);
                // ldateOfBirth.setMonth(lmonth);
                // ldateOfBirth.setYear(lyear);

                // System.out.print("Gender: ");
                // String lgender = scanner.next();

                // System.out.print("Address: ");
                // String laddress = scanner.nextLine();
                // scanner.nextLine();

                // System.out.print("Phone number: ");
                // String lphoneNumber = scanner.nextLine();

                // System.out.print("Email: ");
                // String lemail = scanner.nextLine();

                // System.out.print("Department: ");
                // String ldepartment = scanner.nextLine();

                // Lecturer lecturer = new Lecturer();
                // lecturer.setId(lid);
                // lecturer.setFullName(lname);
                // lecturer.setDateOfBirth(ldateOfBirth);
                // lecturer.setGender(lgender);
                // lecturer.setAddress(laddress);
                // lecturer.setPhoneNumber(lphoneNumber);
                // lecturer.setEmail(lemail);
                // lecturer.setDepartment(ldepartment);

                // if (admin.checkLecture(lid) == true) {
                //     System.out.println("Lecture already exists.");
                //     break;
                // } else if (admin.addLecturer(lecturer)) {
                //     System.out.println("Lecturer added successfully.");
                // } else {
                //     System.out.println("Failed to add lecturer.");
                // }

                Add addStudent = new Add();
                addStudent.addLecture(admin);

                break;
            case 2:
                // update lecture
                System.out.print("Enter lecture's ID: ");
                String lectureIdUpdate = scanner.next();
                scanner.nextLine();

                if (admin.checkLecture(lectureIdUpdate) == false) {
                    System.out.println("Lecture does not exist.");
                    break;
                } else {
                    System.out.print("Full name: ");
                    String uLname = scanner.nextLine();

                    System.out.print("Date of birth: ");
                    int uLday = scanner.nextInt();
                    System.out.print("Month of birth: ");
                    int uLmonth = scanner.nextInt();
                    System.out.print("Year of birth: ");
                    int uLyear = scanner.nextInt();
                    DateOfBirth uLdateOfBirth = new DateOfBirth();
                    uLdateOfBirth.setDay(uLday);
                    uLdateOfBirth.setMonth(uLmonth);
                    uLdateOfBirth.setYear(uLyear);

                    System.out.print("Gender: ");
                    String uLgender = scanner.next();

                    System.out.print("Address: ");
                    String uLaddress = scanner.nextLine();
                    scanner.nextLine();

                    System.out.print("Phone number: ");
                    String uLphoneNumber = scanner.nextLine();

                    System.out.print("Email: ");
                    String uLemail = scanner.nextLine();

                    System.out.print("Department: ");
                    String uLdepartment = scanner.nextLine();

                    Lecturer lecturer1 = new Lecturer();
                    lecturer1.setFullName(uLname);
                    lecturer1.setDateOfBirth(uLdateOfBirth);
                    lecturer1.setGender(uLgender);
                    lecturer1.setAddress(uLaddress);
                    lecturer1.setPhoneNumber(uLphoneNumber);
                    lecturer1.setEmail(uLemail);
                    lecturer1.setDepartment(uLdepartment);

                    if (admin.updateLecture(lectureIdUpdate, lecturer1)) {
                        System.out.println("Lecture updated successfully.");
                    } else {
                        System.out.println("Failed to update lecture.");
                    }
                    break;
                }
            case 3:
                // delete lecture
                System.out.print("Enter lecture's ID: ");
                String lectureId = scanner.next();
                if (admin.checkLecture(lectureId) == false) {
                    System.out.println("Lecture does not exist.");
                    break;
                } else {
                    System.out.print("Are you sure you want to delete this lecture? (y/n)");
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
                break;
            case 4:
                // view lecture
                // admin.viewLecture();
                View viewLecture = new View();
                viewLecture.viewLecture();
                break;
            case 0:
                System.out.println("Back to main menu...");
                System.out.println("--------MANAGE FAP SYSTEM--------");
                System.out.println("1. Manage student");
                System.out.println("2. Manage lecturer");
                System.out.println("3. Manage administrator");
                System.out.println("3. Manage course");
                System.out.println("5. Manage class");
                System.out.println("4. Manage timetable");
                System.out.println("5. Manage grade");
                System.out.println("8. Manage account");
                System.out.println("0. Exit");
                System.out.println("----------------------------------");

                System.out.print("Choose your option: ");

                break;
            default:
                break;
        }
    }
}
