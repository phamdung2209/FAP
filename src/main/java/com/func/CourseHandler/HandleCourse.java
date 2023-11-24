package com.func.CourseHandler;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.course.Course;
import com.func.BackToMain;
import com.persons.Administrator;

public class HandleCourse {
    public Scanner scanner = new Scanner(System.in);

    public void processCourse(int courseOption, Administrator admin) {
        switch (courseOption) {
            case 1:
                // add course
                Add add = new Add();
                add.addCourse(admin);
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
                    Update update = new Update();
                    update.updateCourse(admin, courseIDUpdate);
                    break;
                }
            case 3:
                // delete course
                Delete delete = new Delete();
                delete.deleteCourse(admin);
                break;
            case 4:
                // view course
                View view = new View();
                view.viewCourse(admin);
                break;
            case 0:
                BackToMain backToMain = new BackToMain();
                backToMain.backToMain();
                break;
            default:
                break;
        }
    }
}
