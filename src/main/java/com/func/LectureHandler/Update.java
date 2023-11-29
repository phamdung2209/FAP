package com.func.LectureHandler;

import java.util.Scanner;

import com.date.DateOfBirth;
import com.persons.Administrator;
import com.persons.Lecturer;

public class Update {
    public Scanner scanner = new Scanner(System.in);

    public void updateLecture(Administrator admin, String lectureIdUpdate) {
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
        scanner.nextLine();

        System.out.print("Gender: ");
        String uLgender = scanner.nextLine();

        System.out.print("Address: ");
        String uLaddress = scanner.nextLine();

        System.out.print("Phone number: ");
        String uLphoneNumber = scanner.nextLine();

        System.out.print("Email: ");
        String uLemail = scanner.nextLine();

        System.out.print("Department: ");
        String uLdepartment = scanner.nextLine();

        Lecturer lec = Lecturer.getLecturer();
        lec.setFullName(uLname);
        lec.setDateOfBirth(uLdateOfBirth);
        lec.setGender(uLgender);
        lec.setAddress(uLaddress);
        lec.setPhoneNumber(uLphoneNumber);
        lec.setEmail(uLemail);
        lec.setDepartment(uLdepartment);

        Administrator administrator = Administrator.getAdministrator();
        administrator.updateLecturer(lectureIdUpdate, lec);
    }
}
