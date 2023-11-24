package com.func.LectureHandler;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.Date.DateOfBirth;
import com.func.BackToMain;
import com.persons.Administrator;
import com.persons.Lecturer;

public class HandleLecture {
    public Scanner scanner = new Scanner(System.in);

    public void processLecture(int lectureOption, Administrator admin) {
        switch (lectureOption) {
            case 1:
                Add addLecture = new Add();
                addLecture.addLecture(admin);

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
                    Update updateLecture = new Update();
                    updateLecture.updateLecture(admin, lectureIdUpdate);
                    break;
                }
            case 3:
                // delete lecture
                Delete deleteLecture = new Delete();
                deleteLecture.deleteLecture(admin);
                break;
            case 4:
                View viewLecture = new View();
                viewLecture.viewLecture(admin);
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
