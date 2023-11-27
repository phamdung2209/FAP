package com.func.GradeHandler;

import java.util.Scanner;

import com.Date.DateOfBirth;
import com.course.Course;
import com.func.Grade;
import com.persons.Administrator;
import com.persons.Lecturer;
import com.persons.Student;

public class Update {
    Scanner scanner = new Scanner(System.in);
    public void updateGrade(Administrator admin) {
        System.out.print("Enter grade's ID: ");
        String studentIdUpdate = scanner.next();

        if (!admin.checkGrade(studentIdUpdate)) {
            System.out.println("Grade does not exist.");
        } else {
            System.out.println("Enter new grade's information: ");
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

            Student student = admin.getStudentById(sid);
            Lecturer lecturer = admin.getLectureById(lid);
            Course course = admin.getCourseById(cid);
            Grade gra = new Grade(student, lecturer, course, grade);

            Administrator administrator = Administrator.getAdministrator();
            administrator.updateGrade(studentIdUpdate, gra);

        }
        // System.out.print("Full name: ");
        // String ufullName = scanner.nextLine();

        // System.out.print("Gender: ");
        // String ugenderString = scanner.nextLine();

        // DateOfBirth udateOfBirth = new DateOfBirth();
        // System.out.print("Date of birth: ");
        // int uday = scanner.nextInt();
        // System.out.print("Month of birth: ");
        // int umonth = scanner.nextInt();
        // System.out.print("Year of birth: ");
        // int uyearDob = scanner.nextInt();
        // udateOfBirth.setDay(uday);
        // udateOfBirth.setMonth(umonth);
        // udateOfBirth.setYear(uyearDob);

        // System.out.print("Year of admission: ");
        // int uyear = scanner.nextInt();
        // scanner.nextLine();

        // System.out.print("Major: ");
        // String umajor = scanner.nextLine();

        // System.out.print("Address: ");
        // String uaddress = scanner.nextLine();

        // System.out.print("Phone number: ");
        // String uphoneNumber = scanner.nextLine();

        // System.out.print("Email: ");
        // String uemail = scanner.nextLine();

        // Student stu = new Student();
        // stu.setFullName(ufullName);
        // stu.setGender(ugenderString);
        // stu.setDateOfBirth(udateOfBirth);
        // stu.setYear(uyear);
        // stu.setMajor(umajor);
        // stu.setAddress(uaddress);
        // stu.setPhoneNumber(uphoneNumber);
        // stu.setEmail(uemail);
        
        // Administrator administrator = new Administrator();
        // administrator.updateStudent(studentIdUpdate, stu);
    }
}
