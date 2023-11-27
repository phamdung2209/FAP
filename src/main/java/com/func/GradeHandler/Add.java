package com.func.GradeHandler;

import java.util.Scanner;

import com.course.Course;
import com.func.Grade;
import com.persons.Administrator;
import com.persons.Lecturer;
import com.persons.Student;

public class Add {
    public Scanner scanner = new Scanner(System.in);

    public void addGrade(Administrator admin) {
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

        if (!admin.checkStudent(sid)) {
            System.out.println("Student does not exist.");
        } else if (!admin.checkLecture(lid)) {
            System.out.println("Lecturer does not exist.");
        } else if (!admin.checkCourse(cid)) {
            System.out.println("Course does not exist.");
        } else {
            Student student = admin.getStudentById(sid);

            Lecturer lecturer = admin.getLectureById(lid);

            Course course = admin.getCourseById(cid);

            Grade gra = new Grade(student, lecturer, course, grade);

            Administrator administrator = Administrator.getAdministrator();
            administrator.addGrade(student, lecturer, course, gra);
        }
    }
}
