package com.func.GradeHandler;

import java.util.Scanner;

import com.course.Course;
import com.func.Grade;
import com.persons.Administrator;
import com.persons.Lecturer;
import com.persons.Student;

public class HandleGrade {
    public Scanner scanner = new Scanner(System.in);

    public void processGrade(Administrator admin, int gradeOption) {
        switch (gradeOption) {
            case 1:
                // add grade
                Add add = new Add();
                add.addGrade(admin);
                break;
            case 2:
                // update grade
                Update update = new Update();
                update.updateGrade(admin);
                break;
            case 3:
                // delete grade
                Delete delete = new Delete();
                delete.deleteGrade(admin);
                break;
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
