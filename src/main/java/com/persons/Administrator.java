package com.persons;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Date.DateOfBirth;
import com.course.Course;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.func.Grade;
import com.func.LectureHandler.Add;
import com.func.LectureHandler.View;

public class Administrator extends User {
    public static final String filePath = "C:\\Users\\ACER\\Documents\\Course\\Advance Programming\\Assignment 2\\Project\\FAP\\src\\main\\java\\service\\data.json";

    private List<Student> studentList;
    private List<Lecturer> lecturerList;
    private List<Course> courseList;
    private List<Grade> gradeList;

    public Administrator() {
        studentList = new ArrayList<>();
        lecturerList = new ArrayList<>();
        courseList = new ArrayList<>();
        gradeList = new ArrayList<>();
    }

    public Administrator(String id, String fullName, DateOfBirth dateOfBirth, genderType gender, String address,
            String phoneNumber, String email, List<Student> studentList) {
        super(id, fullName, dateOfBirth, gender, address, phoneNumber, email);
        this.studentList = studentList;
    }

    // ==================== Student ====================
    // save student to file json.data

    public boolean addStudent(Student student) {
        try {
            // Read existing data from file
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            // Deserialize JSON file into a Map
            TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
            };
            HashMap<String, Object> data = objectMapper.readValue(file, typeRef);

            // Extract the "students" key and add a new student
            List<Map<String, String>> students = (List<Map<String, String>>) data.get("students");
            if (students == null) {
                students = new ArrayList<>();
            }

            Map<String, String> newStudent = new HashMap<>();
            newStudent.put("id", student.getId());
            newStudent.put("name", student.getFullName());
            newStudent.put("address", student.getAddress());
            newStudent.put("gender", String.valueOf(student.getGender()));
            newStudent.put("day", String.valueOf(student.getDateOfBirth().getDay()));
            newStudent.put("month", String.valueOf(student.getDateOfBirth().getMonth()));
            newStudent.put("year", String.valueOf(student.getDateOfBirth().getYear()));
            newStudent.put("years", String.valueOf(student.getYear()));
            newStudent.put("major", student.getMajor());
            newStudent.put("phone", student.getPhoneNumber());
            newStudent.put("email", student.getEmail());

            students.add(newStudent);
            data.put("students", students);

            // Write the updated data back to the file
            objectMapper.writeValue(file, data);
            System.out.println("Student added successfully.");
            return true;

        } catch (IOException e) {
            System.err.println("Error reading/writing to file: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // view student
    public void viewStudent() {
        try {
            // Read JSON file into a Map
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            // Deserialize JSON file into a Map
            TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
            };
            Map<String, Object> data = objectMapper.readValue(file, typeRef);

            // Extract data from the "students" key
            List<Map<String, String>> students = (List<Map<String, String>>) data.get("students");

            // Print the student data
            System.out.format("%-10s %-15s %-15s %-10s %-10s %-15s %-20s %-15s %-5s\n",
                    "ID", "Name", "Date of birth", "Gender", "Address", "Phone number", "Email", "Major", "Year");
            for (Map<String, String> student : students) {
                System.out.format("%-10s %-15s %-15s %-10s %-10s %-15s %-20s %-15s %-5s\n",
                        student.get("id"), student.get("name"),
                        student.get("day") + "/" + student.get("month") + "/"
                                + student.get("year"),
                        student.get("gender"), student.get("address"), student.get("phone"), student.get("email"),
                        student.get("major"), student.get("years") + "\n");
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // delete student
    public boolean deleteStudent(String studentId) {
        try {
            // Read JSON file into a Map
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            // Deserialize JSON file into a Map
            TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
            };
            Map<String, Object> data = objectMapper.readValue(file, typeRef);

            // Extract data from the "students" key
            List<Map<String, String>> students = (List<Map<String, String>>) data.get("students");

            // Find and delete the student with the specified ID
            students.removeIf(student -> studentId.equals(student.get("id")));

            // Update the "students" key in the data map
            data.put("students", students);

            // Write the updated data back to the file
            objectMapper.writeValue(file, data);

            return true;

        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkStudent(String studentId) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
            };
            Map<String, Object> data = objectMapper.readValue(file, typeRef);

            // Extract data from the "students" key
            List<Map<String, String>> students = (List<Map<String, String>>) data.get("students");
            for (Map<String, String> student : students) {
                if (student.get("id").equals(studentId)) {
                    return true;
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    // Update information of student by id and save to file json.data
    public boolean updateStudent(String id, Student... students) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
            };
            Map<String, Object> data = objectMapper.readValue(file, typeRef);

            List<Map<String, String>> studentList = (List<Map<String, String>>) data.get("students");

            for (Student student : students) {
                for (Map<String, String> studentMap : studentList) {
                    if (id.equals(studentMap.get("id"))) {
                        studentMap.put("name", student.getFullName());
                        studentMap.put("address", student.getAddress());
                        studentMap.put("gender", String.valueOf(student.getGender()));
                        studentMap.put("day", String.valueOf(student.getDateOfBirth().getDay()));
                        studentMap.put("month", String.valueOf(student.getDateOfBirth().getMonth()));
                        studentMap.put("year", String.valueOf(student.getDateOfBirth().getYear()));
                        studentMap.put("years", String.valueOf(student.getYear()));
                        studentMap.put("major", student.getMajor());
                        studentMap.put("phone", student.getPhoneNumber());
                        studentMap.put("email", student.getEmail());

                        break;
                    }
                }
            }

            // Update the "students" key in the data map
            data.put("students", studentList);
            objectMapper.writeValue(file, data);
            System.out.println("Student with ID " + id + " updated successfully.");
            return true;

        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // ==================== Lecturer ====================
    public boolean addLecturer(Lecturer lecturer) {
        if (lecturerList.add(lecturer)) {
            return true;
        } else {
            return false;
        }
    }

    // view lecturer
    public void viewLecture() {
        // 1) use this function to view lecturer from array list

        // System.out.format("%-10s %-15s %-15s %-10s %-10s %-15s %-20s %-15s\n",
        // "ID", "Full Name", "Date Of Birth", "Gender", "Address", "Phone Number",
        // "Email", "Department");
        // lecturerList.forEach(lecture -> {
        // System.out.format("%-10s %-15s %-15s %-10s %-10s %-15s %-20s %-15s\n",
        // lecture.getId(), lecture.getFullName(),
        // lecture.getDateOfBirth().getDay() + "/" + lecture.getDateOfBirth().getMonth()
        // + "/"
        // + lecture.getDateOfBirth().getYear(),
        // lecture.getGender(), lecture.getAddress(), lecture.getPhoneNumber(),
        // lecture.getEmail(),
        // lecture.getDepartment() + "\n");
        // });

        // 2) use this function to view lecturer from json file
    }

    // update Lecture
    public boolean updateLecture(String id, Lecturer lecturer) {
        for (Lecturer lecturer1 : lecturerList) {
            if (lecturer1.getId().equals(id)) {
                lecturer1.setFullName(lecturer.getFullName());
                lecturer1.setDateOfBirth(lecturer.getDateOfBirth());
                // lecturer1.setGender((String) lecturer.getGender());
                lecturer1.setGender("lecturer.getGender()");
                lecturer1.setAddress(lecturer.getAddress());
                lecturer1.setPhoneNumber(lecturer.getPhoneNumber());
                lecturer1.setEmail(lecturer.getEmail());
                lecturer1.setDepartment(lecturer.getDepartment());
                return true;
            }
        }
        return false;
    }

    // delete Lecture
    public boolean deleteLecture(String lectureId) {
        for (Lecturer lecturer : lecturerList) {
            if (lecturer.getId().equals(lectureId)) {
                lecturerList.remove(lecturer);
                return true;
            }
        }
        return false;
    }

    public boolean checkLecture(String lectureId) {
        // for (Lecturer lecturer : lecturerList) {
        // if (lecturer.getId().equals(lectureId)) {
        // return true;
        // }
        // }

        // return false;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
            };
            Map<String, Object> data = objectMapper.readValue(file, typeRef);

            // Extract data from the "lectures" key
            List<Map<String, String>> lectures = (List<Map<String, String>>) data.get("lectures");
            for (Map<String, String> lecture : lectures) {
                if (lecture.get("id").equals(lectureId)) {
                    return true;
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    // ==================== Course ====================
    // add course
    public boolean addCourse(Course course) {
        if (courseList.add(course)) {
            return true;
        } else {
            return false;
        }
    }

    // view course
    public void viewCourse() {
        System.out.format("%-10s %-15s %-15s %-10s\n",
                "ID", "Course Name", "Description", "Cost"/*
                                                           * , "Student", "Lecturer", "Start Date", "End Date", "Status"
                                                           */);
        courseList.forEach(course -> {
            System.out.format("%-10s %-15s %-15s %-10s\n",
                    course.getId(), course.getCourseName(), course.getDescription(), course.getCost()
                            /*
                             * ,course.getStudent().getFullName(), course.getLecturer().getFullName(),
                             * course.getStartDate().getDay() + "/" + course.getStartDate().getMonth() + "/"
                             * + course.getStartDate().getYear(),
                             * course.getEndDate().getDay() + "/" + course.getEndDate().getMonth() + "/"
                             * + course.getEndDate().getYear(),
                             * course.getStatus()
                             */ + "\n");
        });
    }

    // update course
    public boolean updateCourse(String id, Course course) {
        for (Course course1 : courseList) {
            if (course1.getId().equals(id)) {
                course1.setCourseName(course.getCourseName());
                course1.setDescription(course.getDescription());
                course1.setCost(course.getCost());
                // course1.setStudent(course.getStudent());
                // course1.setLecturer(course.getLecturer());
                // course1.setStartDate(course.getStartDate());
                // course1.setEndDate(course.getEndDate());
                // course1.setStatus(course.getStatus());
                return true;
            }
        }
        return false;
    }

    // delete course
    public boolean deleteCourse(String id) {
        for (Course course : courseList) {
            if (id.equals(course.getId())) {
                courseList.remove(course);
                return true;
            }
        }
        return false;
    }

    // check course
    public boolean checkCourse(String courseId) {
        for (Course course : courseList) {
            if (courseId.equals(course.getId())) {
                return true;
            }
        }
        return false;
    }

    // ==================== Grade ====================
    // add grade
    public boolean addGrade(Student student, Lecturer lecturer, Course course, Grade grade) {
        if (checkStudent(student.getId()) && checkLecture(lecturer.getId()) && checkCourse(course.getId())) {
            gradeList.add(grade);
            return true;
        }
        return false;
    }

    // view grade
    public void viewGrade() {
        System.out.format("%-10s %-15s %-15s %-20s %-10s\n",
                "id", "Student", "Lecturer", "Course", "Grade");
        gradeList.forEach(grade -> {
            System.out.format("%-10s %-15s %-15s %-20s %-10s\n",
                    grade.getId(), grade.getStudent().getFullName(), grade.getLecturer().getFullName(),
                    grade.getCourse().getCourseName(), grade.getGradeAsm() + "\n");
        });
    }

    // get Student by id
    public Student getStudentById(String id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // get Lecturer by id
    public Lecturer getLectureById(String id) {
        for (Lecturer lecturer : lecturerList) {
            if (lecturer.getId().equals(id)) {
                return lecturer;
            }
        }
        return null;
    }

    // get Course by id
    public Course getCourseById(String id) {
        for (Course course : courseList) {
            if (course.getId().equals(id)) {
                return course;
            }
        }
        return null;
    }
}