package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.course.Course;
import com.func.Grade;
import com.persons.Administrator;
import com.persons.Lecturer;
import com.persons.Student;
import com.persons.User;

public class Main2 {
    public static void main(String[] args) {
        // ThreadSafe Singleton Pattern - Creational Pattern
        Administrator administrator = Administrator.getAdministrator();
        administrator.addStudent(null);

        // Factory Method Pattern - Creational Pattern
        com.func.View viewStudent = User.getUser(Student.getStudent().getPersonType());
        com.func.View viewLecturer = User.getUser(Lecturer.getLecturer().getPersonType());
        com.func.View viewAdmin = User.getUser(Administrator.getAdministrator().getPersonType());

        // viewStudent.viewGrade(); // View grade of student
        // viewLecturer.viewGrade(); // View grade of lecturer
        viewAdmin.viewGrade(); // View grade of admin

        // builder pattern
        User user = new User.UserBuilder()
                .setId("123")
                .setFullName("Nguyen Van A")
                .build();

        // adapter pattern
        AdministratorAdapter adminAdapter = new AdministratorAdapter(administrator);
        adminAdapter.viewCourse();

        // composite pattern
        getNotify administrator1 = new Administrator1();
        AdministratorGroup administratorGroup = new AdministratorGroup();
        administratorGroup.addAdministrator(administrator1);
        administratorGroup.display();

        // decorator pattern
        User1 basicUser = new BasicUser("Dung Pham");
        User1 studentUser = new StudentDecorator(basicUser, "Student ID: BH00268");

        System.out.println(basicUser.getInfo());
        System.out.println(studentUser.getInfo());

        // Iterator pattern
        Students student1 = new Students("1", "A");
        Students student2 = new Students("2", "B");

        List<Students> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        Iterator iteratorStudent = students.iterator();
        while(iteratorStudent.hasNext()){
            Students student = (Students) iteratorStudent.next();
            System.out.println(student.toString());
        }

        // Observer pattern
        CourseSubject courseSubject = new CourseSubject();
        courseSubject.attach(new StudentObserver("Student 1"));
        courseSubject.attach(new StudentObserver("Student 2"));
        courseSubject.attach(new StudentObserver("Student 3"));

        courseSubject.notify("New course has been added");

        // Usage in main function
        Grade grade = new Grade();
        Student student = new Student("Student 1");
        grade.addObserver(student);
        grade.updateGrade("100");

        // Strategy pattern
        Context context = new Context(new AddCourse());
        context.executeStrategy();

    }
}

// Adapter pattern - Structural Pattern
class AdministratorAdapter extends User {
    private Administrator admin;

    public AdministratorAdapter(Administrator admin) {
        this.admin = admin;
    }

    @Override
    public void viewCourse() {
        admin.viewCourse();
    }

    @Override
    public void viewGrade() {
        admin.viewGrade();
    }

    @Override
    public void viewTimetable() {
        admin.viewTimetable();
    }

    @Override
    public void viewClass() {
        admin.viewClass();
    }
}

// composite pattern - Structural Pattern
interface getNotify {
    void display();
}

class AdministratorGroup implements getNotify {
    private List<getNotify> administrators = new ArrayList<>();

    public AdministratorGroup() {
    }

    public void addAdministrator(getNotify administrator) {
        administrators.add(administrator);
    }

    @Override
    public void display() {
        System.out.println("Administrator Group");
        administrators.forEach(getNotify::display);
    }
}

class Administrator1 implements getNotify {

    @Override
    public void display() {
        System.out.println("Administrator has been added");
    }

}


// decorator pattern - Structural Pattern
interface User1 {
    String getInfo();
}

// Concrete Component
class BasicUser implements User1 {
    private String name;

    BasicUser(String name) {
        this.name = name;
    }

    @Override
    public String getInfo() {
        return "User: " + name;
    }
}

// Decorator
class StudentDecorator implements User1 {
    private User1 user1;
    private String studentInfo;

    StudentDecorator(User1 user1, String studentInfo) {
        this.user1 = user1;
        this.studentInfo = studentInfo;
    }

    @Override
    public String getInfo() {
        return user1.getInfo() + ", " + studentInfo;
    }
}


class Students{
    private String id;
    private String fullName;

    public Students(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
}


// observer pattern - Behavioral Pattern
interface Observer {
    void update(String message);
}

interface Subject {
    void attach(Observer observer);

    void detach(Observer observer);

    void notify(String message);
}

class StudentObserver implements Observer {
    private String name;

    public StudentObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}

class CourseSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notify(String message) {
        observers.forEach(observer -> observer.update(message));
    }
}

// Strategy pattern - Behavioral Pattern
interface Strategy {
    void execute();
}

class AddCourse implements Strategy {
    @Override
    public void execute() {
        System.out.println("Add course");
    }
}

class UpdateCourse implements Strategy {
    @Override
    public void execute() {
        System.out.println("Update course");
    }
}

class DeleteCourse implements Strategy {
    @Override
    public void execute() {
        System.out.println("Delete course");
    }
}

class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.execute();
    }
}

