package com;

import java.sql.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.Date.DateOfBirth;
import com.course.Course;
import com.func.Grade;
import com.func.LectureHandler.HandleLecture;
import com.func.StudentHandler.Add;
import com.func.StudentHandler.HandleStudent;
import com.persons.Administrator;
import com.persons.Lecturer;
import com.persons.Student;

public class Main {
    public static void main(String[] args) {
        Administrator admin = new Administrator();
        Scanner scanner = new Scanner(System.in);
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
                                // switch (lectureOption) {
                                //     case 1:
                                //         System.out.println("Enter lecture's information:");
                                //         System.out.print("ID: ");
                                //         String lid = scanner.next();
                                //         scanner.nextLine();

                                //         System.out.print("Full name: ");
                                //         String lname = scanner.nextLine();

                                //         System.out.print("Date of birth: ");
                                //         int lday = scanner.nextInt();
                                //         System.out.print("Month of birth: ");
                                //         int lmonth = scanner.nextInt();
                                //         System.out.print("Year of birth: ");
                                //         int lyear = scanner.nextInt();
                                //         DateOfBirth ldateOfBirth = new DateOfBirth();
                                //         ldateOfBirth.setDay(lday);
                                //         ldateOfBirth.setMonth(lmonth);
                                //         ldateOfBirth.setYear(lyear);

                                //         System.out.print("Gender: ");
                                //         String lgender = scanner.next();

                                //         System.out.print("Address: ");
                                //         String laddress = scanner.nextLine();
                                //         scanner.nextLine();

                                //         System.out.print("Phone number: ");
                                //         String lphoneNumber = scanner.nextLine();

                                //         System.out.print("Email: ");
                                //         String lemail = scanner.nextLine();

                                //         System.out.print("Department: ");
                                //         String ldepartment = scanner.nextLine();

                                //         Lecturer lecturer = new Lecturer();
                                //         lecturer.setId(lid);
                                //         lecturer.setFullName(lname);
                                //         lecturer.setDateOfBirth(ldateOfBirth);
                                //         lecturer.setGender(lgender);
                                //         lecturer.setAddress(laddress);
                                //         lecturer.setPhoneNumber(lphoneNumber);
                                //         lecturer.setEmail(lemail);
                                //         lecturer.setDepartment(ldepartment);

                                //         if (admin.checkLecture(lid) == true) {
                                //             System.out.println("Lecture already exists.");
                                //             break;
                                //         } else if (admin.addLecturer(lecturer)) {
                                //             System.out.println("Lecturer added successfully.");
                                //         } else {
                                //             System.out.println("Failed to add lecturer.");
                                //         }

                                //         break;
                                //     case 2:
                                //         // update lecture
                                //         System.out.print("Enter lecture's ID: ");
                                //         String lectureIdUpdate = scanner.next();
                                //         scanner.nextLine();

                                //         if (admin.checkLecture(lectureIdUpdate) == false) {
                                //             System.out.println("Lecture does not exist.");
                                //             break;
                                //         } else {
                                //             System.out.print("Full name: ");
                                //             String uLname = scanner.nextLine();

                                //             System.out.print("Date of birth: ");
                                //             int uLday = scanner.nextInt();
                                //             System.out.print("Month of birth: ");
                                //             int uLmonth = scanner.nextInt();
                                //             System.out.print("Year of birth: ");
                                //             int uLyear = scanner.nextInt();
                                //             DateOfBirth uLdateOfBirth = new DateOfBirth();
                                //             uLdateOfBirth.setDay(uLday);
                                //             uLdateOfBirth.setMonth(uLmonth);
                                //             uLdateOfBirth.setYear(uLyear);

                                //             System.out.print("Gender: ");
                                //             String uLgender = scanner.next();

                                //             System.out.print("Address: ");
                                //             String uLaddress = scanner.nextLine();
                                //             scanner.nextLine();

                                //             System.out.print("Phone number: ");
                                //             String uLphoneNumber = scanner.nextLine();

                                //             System.out.print("Email: ");
                                //             String uLemail = scanner.nextLine();

                                //             System.out.print("Department: ");
                                //             String uLdepartment = scanner.nextLine();

                                //             Lecturer lecturer1 = new Lecturer();
                                //             lecturer1.setFullName(uLname);
                                //             lecturer1.setDateOfBirth(uLdateOfBirth);
                                //             lecturer1.setGender(uLgender);
                                //             lecturer1.setAddress(uLaddress);
                                //             lecturer1.setPhoneNumber(uLphoneNumber);
                                //             lecturer1.setEmail(uLemail);
                                //             lecturer1.setDepartment(uLdepartment);

                                //             if (admin.updateLecture(lectureIdUpdate, lecturer1)) {
                                //                 System.out.println("Lecture updated successfully.");
                                //             } else {
                                //                 System.out.println("Failed to update lecture.");
                                //             }
                                //             break;
                                //         }
                                //     case 3:
                                //         // delete lecture
                                //         System.out.print("Enter lecture's ID: ");
                                //         String lectureId = scanner.next();
                                //         if (admin.checkLecture(lectureId) == false) {
                                //             System.out.println("Lecture does not exist.");
                                //             break;
                                //         } else {
                                //             System.out.print("Are you sure you want to delete this lecture? (y/n)");
                                //             String confirm = scanner.next();
                                //             switch (confirm) {
                                //                 case "Y":
                                //                 case "y":
                                //                     System.out.println("Deleting lecture...");
                                //                     if (admin.deleteLecture(lectureId)) {
                                //                         new Timer().schedule(new TimerTask() {
                                //                             public void run() {
                                //                                 admin.deleteLecture(lectureId);
                                //                                 System.out.println("Lecture deleted successfully.");
                                //                             }
                                //                         }, 3000);
                                //                     } else {
                                //                         System.out.println("Failed to delete lecture.");
                                //                     }
                                //                     break;
                                //                 case "N":
                                //                 case "n":
                                //                     System.out.println("Canceling...");
                                //                     break;
                                //                 default:
                                //                     System.out.println("Invalid input. Please enter Y or N.");
                                //                     break;
                                //             }
                                //         }
                                //         break;
                                //     case 4:
                                //         // view lecture
                                //         admin.viewLecture();
                                //         break;
                                //     case 0:
                                //         System.out.println("Back to main menu...");
                                //         System.out.println("--------MANAGE FAP SYSTEM--------");
                                //         System.out.println("1. Manage student");
                                //         System.out.println("2. Manage lecturer");
                                //         System.out.println("3. Manage administrator");
                                //         System.out.println("3. Manage course");
                                //         System.out.println("5. Manage class");
                                //         System.out.println("4. Manage timetable");
                                //         System.out.println("5. Manage grade");
                                //         System.out.println("8. Manage account");
                                //         System.out.println("0. Exit");
                                //         System.out.println("----------------------------------");

                                //         System.out.print("Choose your option: ");

                                //         break;
                                //     default:
                                //         break;
                                // }

                                HandleLecture handleLecture = new HandleLecture();
                                handleLecture.processLecture(lectureOption, admin);
                            }
                        }

                        break;
                    case 4:
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
                                switch (courseOption) {
                                    case 1:
                                        // add course
                                        System.out.println("Enter course's information:");
                                        System.out.print("ID: ");
                                        String cid = scanner.next();
                                        scanner.nextLine();

                                        System.out.print("Course Name: ");
                                        String cname = scanner.nextLine();

                                        System.out.print("Description: ");
                                        String cDescription = scanner.nextLine();

                                        System.out.print("Cost: ");
                                        Long cCost = scanner.nextLong();

                                        // System.out.print("Lecturer: ");
                                        // String clecturer = scanner.nextLine();

                                        Course course = new Course(cid, cname, cDescription, cCost);

                                        if (admin.checkCourse(cid) == true) {
                                            System.out.println("Course already exists.");
                                            break;
                                        } else if (admin.addCourse(course)) {
                                            System.out.println("Course added successfully.");
                                        } else {
                                            System.out.println("Failed to add course.");
                                        }
                                        break;
                                    case 2:
                                        // update course
                                        System.out.print("Enter course's ID: ");
                                        String courseIDUpdate = scanner.next();
                                        scanner.nextLine();

                                        if (admin.checkCourse(courseIDUpdate) == false) {
                                            System.out.println("Course does not exist.");
                                            break;
                                        } else {
                                            System.out.print("Course Name: ");
                                            String uCname = scanner.nextLine();

                                            System.out.print("Description: ");
                                            String uCDescription = scanner.nextLine();

                                            System.out.print("Cost: ");
                                            Long uCCost = scanner.nextLong();

                                            Course course1 = new Course();
                                            course1.setCourseName(uCname);
                                            course1.setDescription(uCDescription);
                                            course1.setCost(uCCost);

                                            if (admin.updateCourse(courseIDUpdate, course1)) {
                                                System.out.println("Course updated successfully.");
                                            } else {
                                                System.out.println("Failed to update course.");
                                            }
                                            break;
                                        }
                                    case 3:
                                        // delete course
                                        System.out.print("Enter course's ID: ");
                                        String courseID = scanner.next();
                                        if (admin.checkCourse(courseID) == false) {
                                            System.out.println("Course does not exist.");
                                            break;
                                        } else {
                                            System.out.print("Are you sure you want to delete this course? (y/n)");
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
                                        break;
                                    case 4:
                                        admin.viewCourse();
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
                        break;
                    case 7:
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
                                switch (gradeOption) {
                                    case 1:
                                        // add grade
                                        System.out.println("Enter grade's information:");
                                        System.out.print("Student ID: ");
                                        String sid = scanner.next();
                                        scanner.nextLine();

                                        System.out.print("Lecturer ID: ");
                                        String lid = scanner.next();
                                        scanner.nextLine();

                                        System.out.print("Course ID: ");
                                        String cid = scanner.next();
                                        scanner.nextLine();

                                        System.out.print("Grade: ");
                                        int grade = scanner.nextInt();

                                        if (admin.checkStudent(sid) == false) {
                                            System.out.println("Student does not exist.");
                                            break;
                                        } else if (admin.checkLecture(lid) == false) {
                                            System.out.println("Lecturer does not exist.");
                                            break;
                                        } else if (admin.checkCourse(cid) == false) {
                                            System.out.println("Course does not exist.");
                                            break;
                                        } else {
                                            Student student = admin.getStudentById(sid);

                                            Lecturer lecturer = admin.getLectureById(lid);

                                            Course course = admin.getCourseById(cid);

                                            Grade grade1 = new Grade(student, lecturer, course, grade);
                                            if (admin.addGrade(student, lecturer, course, grade1)) {
                                                System.out.println("Grade added successfully.");
                                            } else {
                                                System.out.println("Failed to add grade.");
                                            }

                                            // admin.addGrade(student, lecturer, course, grade);
                                            break;
                                        }
                                    case 4:
                                        admin.viewGrade();
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
                                }
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
