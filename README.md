# FAP - School Management System

![FAP Logo](https://fap.fpi.edu.vn/logo-Btec.jpg)

> [![View count](https://visitcount.itsvg.in/api?id=lucthienphong1120&color=6&icon=0&pretty=true)](https://visitcount.itsvg.in/api?id=phamdung2209)

<img src="https://user-images.githubusercontent.com/73097560/115834477-dbab4500-a447-11eb-908a-139a6edaec5c.gif">

<p align="center" color="#36BCF7FF"><img src="https://readme-typing-svg.herokuapp.com?lines=I'm+Dung+Pham;I'm+a+Full+Stack+Developer;I'm+a+Blogger"></p>

## Introduction

FAP is a school management system built with Java and utilizes JSON for data storage. It facilitates administrators and teachers in managing student information, teacher details, course data, and lectures.

## Features

- **Student Management:**
  - Add, delete, and update student information.
  - View personal details and academic progress of students.

- **Teacher Management:**
  - Add, delete, and update teacher information.
  - View a list of teachers and the courses they teach.

- **Course Management:**
  - Create, edit, delete course information.
  - View the list of courses and the number of students enrolled.

- **Grade Management:**
  - Add, delete, and update Grade information of student.
  - View the list of students graded by instructors.

- **Class Management:**
  - More classes, new homeroom teacher.
  - Add students to class.

- **Updating:**

## Installation and Execution

### Requirements
Java 17 or higher
- [Java](https://www.oracle.com/java/technologies/javase-downloads.html)

1. **Installation:**
   - Clone the project to your machine.
   - Open the project in your preferred IDE.

    ```bash
    git clone https://github.com/phamdung2209/FAP.git
    cd FAP
    ```

2. **Run the Application:**
   - Execute the file 
    ```bash
    @ECHO OFF
    java -jar target/FAP-1.0-SNAPSHOT.jar
    PAUSE
    ```

to start the application.

3. **Access the Application:**
- After starting the application, it will run in the terminal, prompting you to enter commands to perform various program functions.

## Data Storage

The project uses JSON to store data instead of traditional database systems. JSON files containing student, teacher, course, and lecture information are stored in the `src/main/java/service/data.json` directory.

## Project Structure

FAP/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── course/
│   │   │   │   │   ├── Course.java
│   │   │   │   │   ├── DateOfBirth.java
│   │   │   │   │   ├── Student.java
│   │   │   │   │   ├── Teacher.java
│   │   │   │   │   └── Lecture.java
│   │   │   │   ├── date/
│   │   │   │   │   ├── DateOfBirth.java
│   │   │   │   │   ├── Schedule.java
│   │   │   │   │   └── Timetable.java
│   │   │   │   ├── fun/
│   │   │   │   │   ├── LectureHandler/
│   │   │   │   │   │   ├── Add.java
│   │   │   │   │   │   ├── Delete.java
│   │   │   │   │   │   ├── Update.java
│   │   │   │   │   │   ├── HandleLecture.java
│   │   │   │   │   │   └── View.java
│   │   │   │   │   ├── StudentHandler/
│   │   │   │   │   │   ├── Add.java
│   │   │   │   │   │   ├── Delete.java
│   │   │   │   │   │   ├── Update.java
│   │   │   │   │   │   ├── HandleStudent.java
│   │   │   │   │   │   └── View.java
│   │   │   │   │   ├── BackToMain.java
│   │   │   │   │   ├── Grade.java
│   │   │   │   │   └── View.java
│   │   │   ├── lib/
│   │   │   └── service/
│   │   │       ├── data.json
│   │   │       └── Test.java
│   │   └── resources/
│   └── test/
├── .idea/
├── .gitignore
├── pom.xml
├── target/
├── CONTRIBUTING.md
├── LICENSE
└── README.md

## Contribution

If you wish to contribute to the project, please read the [Contribution Guidelines](CONTRIBUTING.md) for more details.

## Bug Reports and Suggestions

If you encounter bugs or have suggestions, please create [a new Issue](https://github.com/phamdung2209/FAP/issues).

## License

This project is distributed under the [MIT License](LICENSE).
