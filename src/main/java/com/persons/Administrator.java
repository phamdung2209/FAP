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
import com.func.ClassroomHandler.Classroom;
import com.func.LectureHandler.Add;
import com.func.LectureHandler.View;

public class Administrator extends User {
    public static final String filePath = "C:\\Users\\ACER\\Documents\\Course\\Advance Programming\\Assignment 2\\Project\\FAP\\src\\main\\java\\service\\data.json";

    private List<Student> studentList;
    private List<Lecturer> lecturerList;
    private List<Course> courseList;
    private List<Grade> gradeList;

    public Administrator() {
        // studentList = new ArrayList<>();
        // lecturerList = new ArrayList<>();
        // courseList = new ArrayList<>();
        // gradeList = new ArrayList<>();
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
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
            };
            HashMap<String, Object> data = objectMapper.readValue(file, typeRef);

            List<Map<String, String>> lectures = (List<Map<String, String>>) data.get("lectures");
            if (lectures == null) {
                lectures = new ArrayList<>();
            }

            Map<String, String> newLecture = new HashMap<>();
            newLecture.put("id", lecturer.getId());
            newLecture.put("name", lecturer.getFullName());
            newLecture.put("address", lecturer.getAddress());
            newLecture.put("gender", String.valueOf(lecturer.getGender()));
            newLecture.put("day", String.valueOf(lecturer.getDateOfBirth().getDay()));
            newLecture.put("month", String.valueOf(lecturer.getDateOfBirth().getMonth()));
            newLecture.put("year", String.valueOf(lecturer.getDateOfBirth().getYear()));
            newLecture.put("phone", lecturer.getPhoneNumber());
            newLecture.put("email", lecturer.getEmail());
            newLecture.put("department", lecturer.getDepartment());

            lectures.add(newLecture);
            data.put("lectures", lectures);

            objectMapper.writeValue(file, data);
            System.out.println("Lecture added successfully.");
            return true;
        } catch (IOException e) {
            System.err.println("Error reading/writing to file: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    // view lecturer
    public void viewLecture() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
            };
            Map<String, Object> data = objectMapper.readValue(file, typeRef);

            List<Map<String, String>> lectures = (List<Map<String, String>>) data.get("lectures");

            // Print the lecture data
            System.out.format("%-10s %-15s %-15s %-10s %-10s %-15s %-20s %-15s\n",
                    "ID", "Full Name", "Date Of Birth", "Gender", "Address", "Phone Number", "Email", "Department");
            for (Map<String, String> lecture : lectures) {
                System.out.format("%-10s %-15s %-15s %-10s %-10s %-15s %-20s %-15s\n",
                        lecture.get("id"), lecture.get("name"),
                        lecture.get("day") + "/" + lecture.get("month") + "/" + lecture.get("year"),
                        lecture.get("gender"), lecture.get("address"), lecture.get("phone"), lecture.get("email"),
                        lecture.get("department") + "\n");
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean updateLecturer(String id, Lecturer... lectures) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
            };
            Map<String, Object> data = objectMapper.readValue(file, typeRef);

            List<Map<String, String>> lectureList = (List<Map<String, String>>) data.get("lectures");

            for (Lecturer lecture : lectures) {
                for (Map<String, String> lectureMap : lectureList) {
                    if (id.equals(lectureMap.get("id"))) {
                        lectureMap.put("name", lecture.getFullName());
                        lectureMap.put("address", lecture.getAddress());
                        lectureMap.put("gender", String.valueOf(lecture.getGender()));
                        lectureMap.put("day", String.valueOf(lecture.getDateOfBirth().getDay()));
                        lectureMap.put("month", String.valueOf(lecture.getDateOfBirth().getMonth()));
                        lectureMap.put("year", String.valueOf(lecture.getDateOfBirth().getYear()));
                        lectureMap.put("phone", lecture.getPhoneNumber());
                        lectureMap.put("email", lecture.getEmail());
                        lectureMap.put("department", lecture.getDepartment());

                        break;
                    }
                }
            }

            // Update the "lectures" key in the data map
            data.put("lectures", lectureList);
            objectMapper.writeValue(file, data);
            System.out.println("Lecture with ID " + id + " updated successfully.");
            return true;

        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // delete Lecture
    public boolean deleteLecture(String lectureId) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
            };
            Map<String, Object> data = objectMapper.readValue(file, typeRef);

            List<Map<String, String>> lectures = (List<Map<String, String>>) data.get("lectures");

            lectures.removeIf(lecture -> lectureId.equals(lecture.get("id")));

            data.put("lectures", lectures);
            objectMapper.writeValue(file, data);

            return true;

        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkLecture(String lectureId) {
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
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
            };
            HashMap<String, Object> data = objectMapper.readValue(file, typeRef);

            List<Map<String, String>> courses = (List<Map<String, String>>) data.get("courses");
            if (courses == null) {
                courses = new ArrayList<>();
            }

            Map<String, String> newCourse = new HashMap<>();
            newCourse.put("id", course.getId());
            newCourse.put("name", course.getCourseName());
            newCourse.put("description", course.getDescription());
            newCourse.put("cost", Long.toString(course.getCost()));

            courses.add(newCourse);
            data.put("courses", courses);

            objectMapper.writeValue(file, data);
            System.out.println("Course added successfully.");
            return true;

        } catch (IOException e) {
            System.err.println("Error reading/writing to file: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // view course
    public void viewCourse() {
        // System.out.format("%-10s %-15s %-15s %-10s\n",
        // "ID", "Course Name", "Description", "Cost"/*
        // * , "Student", "Lecturer", "Start Date", "End Date", "Status"
        // */);
        // courseList.forEach(course -> {
        // System.out.format("%-10s %-15s %-15s %-10s\n",
        // course.getId(), course.getCourseName(), course.getDescription(),
        // course.getCost()
        // /*
        // * ,course.getStudent().getFullName(), course.getLecturer().getFullName(),
        // * course.getStartDate().getDay() + "/" + course.getStartDate().getMonth() +
        // "/"
        // * + course.getStartDate().getYear(),
        // * course.getEndDate().getDay() + "/" + course.getEndDate().getMonth() + "/"
        // * + course.getEndDate().getYear(),
        // * course.getStatus()
        // */ + "\n");
        // });

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
            };
            Map<String, Object> data = objectMapper.readValue(file, typeRef);

            List<Map<String, String>> courses = (List<Map<String, String>>) data.get("courses");

            // Print the lecture data
            System.out.format("%-10s %-15s %-15s %-10s\n",
                    "ID", "Course Name", "Description", "Cost"/*
                                                               * , "Student", "Lecturer", "Start Date", "End Date",
                                                               * "Status"
                                                               */);
            for (Map<String, String> course : courses) {
                System.out.format("%-10s %-15s %-15s %-10s\n",
                        course.get("id"), course.get("name"), course.get("description"), course.get("cost")
                                /*
                                 * ,course.getStudent().getFullName(), course.getLecturer().getFullName(),
                                 * course.getStartDate().getDay() + "/" + course.getStartDate().getMonth() + "/"
                                 * + course.getStartDate().getYear(),
                                 * course.getEndDate().getDay() + "/" + course.getEndDate().getMonth() + "/"
                                 * + course.getEndDate().getYear(),
                                 * course.getStatus()
                                 */ + "\n");
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // update course
    public boolean updateCourse(String id, Course... courses) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
            };
            Map<String, Object> data = objectMapper.readValue(file, typeRef);

            List<Map<String, String>> courseList = (List<Map<String, String>>) data.get("courses");

            for (Course course : courses) {
                for (Map<String, String> courseMap : courseList) {
                    if (id.equals(courseMap.get("id"))) {
                        courseMap.put("name", course.getCourseName());
                        courseMap.put("description", course.getDescription());
                        courseMap.put("cost", Long.toString(course.getCost()));

                        break;
                    }
                }
            }

            // Update the "courses" key in the data map
            data.put("courses", courseList);
            objectMapper.writeValue(file, data);
            System.out.println("Course with ID " + id + " updated successfully.");
            return true;

        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // delete course
    public boolean deleteCourse(String id) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
            };
            Map<String, Object> data = objectMapper.readValue(file, typeRef);

            List<Map<String, String>> courses = (List<Map<String, String>>) data.get("courses");

            courses.removeIf(course -> id.equals(course.get("id")));

            data.put("courses", courses);
            objectMapper.writeValue(file, data);

            return true;

        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // check course
    public boolean checkCourse(String courseId) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
            };
            Map<String, Object> data = objectMapper.readValue(file, typeRef);

            // Extract data from the "courses" key
            List<Map<String, String>> courses = (List<Map<String, String>>) data.get("courses");
            for (Map<String, String> course : courses) {
                if (course.get("id").equals(courseId)) {
                    return true;
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    // ==================== Grade ====================
    // add grade
    public boolean addGrade(Student student, Lecturer lecturer, Course course, Grade grade) {
        if (checkStudent(student.getId()) && checkLecture(lecturer.getId()) &&
                checkCourse(course.getId())) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                File file = new File(filePath);

                TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
                };
                HashMap<String, Object> data = objectMapper.readValue(file, typeRef);

                List<Map<String, String>> grades = (List<Map<String, String>>) data.get("grades");
                if (grades == null) {
                    grades = new ArrayList<>();
                }

                Map<String, String> newGrade = new HashMap<>();
                newGrade.put("id", Integer.toString(grade.getId()));
                newGrade.put("studentId", student.getId());
                newGrade.put("lecturerId", lecturer.getId());
                newGrade.put("courseId", course.getId());
                newGrade.put("grade", Integer.toString(grade.getGradeAsm()));

                grades.add(newGrade);
                data.put("grades", grades);

                objectMapper.writeValue(file, data);
                System.out.println("Grade added successfully.");
                return true;

            } catch (IOException e) {
                System.err.println("Error reading/writing to file: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return false;
    }

    // view grade
    public void viewGrade() {
        // System.out.format("%-10s %-15s %-15s %-20s %-10s\n",
        // "id", "Student", "Lecturer", "Course", "Grade");
        // gradeList.forEach(grade -> {
        // System.out.format("%-10s %-15s %-15s %-20s %-10s\n",
        // grade.getId(), grade.getStudent().getFullName(),
        // grade.getLecturer().getFullName(),
        // grade.getCourse().getCourseName(), grade.getGradeAsm() + "\n");
        // });

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
            };
            Map<String, Object> data = objectMapper.readValue(file, typeRef);

            List<Map<String, String>> grades = (List<Map<String, String>>) data.get("grades");

            // Print the student data
            System.out.format("%-10s %-15s %-15s %-20s %-10s\n",
                    "id", "Student", "Lecturer", "Course", "Grade");
            for (Map<String, String> grade : grades) {
                String studentId = grade.get("studentId");
                String lecturerId = grade.get("lecturerId");
                String courseId = grade.get("courseId");

                Student student = getStudentById(studentId);
                Lecturer lecturer = getLectureById(lecturerId);
                Course course = getCourseById(courseId);

                System.out.format("%-10s %-15s %-15s %-20s %-10s\n",
                        grade.get("id"), student.getFullName(), lecturer.getFullName(), course.getCourseName(),
                        grade.get("grade") + "\n");
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean checkGrade(String id) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
            };
            Map<String, Object> data = objectMapper.readValue(file, typeRef);

            // Extract data from the "grades" key
            List<Map<String, String>> grades = (List<Map<String, String>>) data.get("grades");
            for (Map<String, String> grade : grades) {
                if (grade.get("id").equals(id)) {
                    return true;
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteGrade(String gradeId) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
            };
            HashMap<String, Object> data = objectMapper.readValue(file, typeRef);

            List<Map<String, String>> grades = (List<Map<String, String>>) data.get("grades");

            grades.removeIf(grade -> gradeId.equals(grade.get("id")));

            data.put("grades", grades);
            objectMapper.writeValue(file, data);

            return true;

        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateGrade(String id, Grade... grades) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);
            TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
            };
            Map<String, Object> data = objectMapper.readValue(file, typeRef);
            List<Map<String, String>> gradeList = (List<Map<String, String>>) data.get("grades");

            for (Grade grade : grades) {
                for (Map<String, String> gradeMap : gradeList) {
                    if (id.equals(gradeMap.get("id"))) {
                        gradeMap.put("studentId", grade.getStudent().getId());
                        gradeMap.put("lecturerId", grade.getLecturer().getId());
                        gradeMap.put("courseId", grade.getCourse().getId());
                        gradeMap.put("grade", Integer.toString(grade.getGradeAsm()));

                        break;
                    }
                }
            }

            // Update the "grades" key in the data map
            data.put("grades", gradeList);
            objectMapper.writeValue(file, data);
            System.out.println("Student with ID " + id + " updated successfully.");
            return true;
        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // get Student by id
    public Student getStudentById(String id) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
            };
            Map<String, Object> data = objectMapper.readValue(file, typeRef);

            List<Map<String, String>> students = (List<Map<String, String>>) data.get("students");

            for (Map<String, String> studentData : students) {
                if (id.equals(studentData.get("id"))) {
                    Student student = new Student();
                    student.setId(id);
                    student.setFullName(studentData.get("name"));
                    student.setGender(studentData.get("gender"));
                    student.setAddress(studentData.get("address"));
                    student.setDateOfBirth(new DateOfBirth(Integer.parseInt(studentData.get("day")),
                            Integer.parseInt(studentData.get("month")), Integer.parseInt(studentData.get("year"))));
                    student.setYear(Integer.parseInt(studentData.get("years")));
                    student.setMajor(studentData.get("major"));
                    student.setPhoneNumber(studentData.get("phone"));
                    student.setEmail(studentData.get("email"));

                    return student;
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    // get Lecturer by id
    public Lecturer getLectureById(String id) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
            };
            Map<String, Object> data = objectMapper.readValue(file, typeRef);

            List<Map<String, String>> lectures = (List<Map<String, String>>) data.get("lectures");

            for (Map<String, String> lectureData : lectures) {
                if (id.equals(lectureData.get("id"))) {
                    Lecturer lecture = new Lecturer();
                    lecture.setId(id);
                    lecture.setFullName(lectureData.get("name"));
                    lecture.setGender(lectureData.get("gender"));
                    lecture.setAddress(lectureData.get("address"));
                    lecture.setDateOfBirth(new DateOfBirth(Integer.parseInt(lectureData.get("day")),
                            Integer.parseInt(lectureData.get("month")), Integer.parseInt(lectureData.get("year"))));
                    lecture.setPhoneNumber(lectureData.get("phone"));
                    lecture.setEmail(lectureData.get("email"));
                    lecture.setDepartment(lectureData.get("department"));

                    return lecture;
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    // get Course by id
    public Course getCourseById(String id) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);

            TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {
            };
            Map<String, Object> data = objectMapper.readValue(file, typeRef);

            List<Map<String, String>> courses = (List<Map<String, String>>) data.get("courses");

            for (Map<String, String> courseData : courses) {
                if (id.equals(courseData.get("id"))) {
                    Course course = new Course();
                    course.setId(id);
                    course.setCourseName(courseData.get("name"));
                    course.setDescription(courseData.get("description"));
                    course.setCost(Long.parseLong(courseData.get("cost")));

                    return course;
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    // ==================== Classroom ====================
    // add classroom
    public boolean addClassroom(Classroom classroom) {
        try {
            // Read existing data from file
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);
            TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
            };
            HashMap<String, Object> data = objectMapper.readValue(file, typeRef);
            List<Map<String, String>> classes = (List<Map<String, String>>) data.get("classes");
            if (classes == null) {
                classes = new ArrayList<>();
            }

            Map<String, String> newClass = new HashMap<>();
            newClass.put("id", classroom.getId());
            newClass.put("name", classroom.getName());
            newClass.put("lecturerId", classroom.getLecturerId());

            classes.add(newClass);
            data.put("classes", classes);

            // Write the updated data back to the file
            objectMapper.writeValue(file, data);
            System.out.println("Class added successfully.");
            return true;

        } catch (IOException e) {
            System.err.println("Error reading/writing to file: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // add student to classroom
    public boolean addStudentToClass(String classId, String idStudent) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);
            TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
            };
            HashMap<String, Object> data = objectMapper.readValue(file, typeRef);
            List<Map<String, String>> classList = (List<Map<String, String>>) data.get("classList");
            if (classList == null) {
                classList = new ArrayList<>();
            }

            Map<String, String> newClassList = new HashMap<>();
            newClassList.put("classId", classId);
            newClassList.put("studentId", idStudent);

            classList.add(newClassList);
            data.put("classList", classList);

            // Write the updated data back to the file
            objectMapper.writeValue(file, data);
            System.out.println("Class added successfully.");
            return true;

        } catch (IOException e) {
            System.err.println("Error reading/writing to file: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // check classroom
    public boolean checkClassroom(String classroomId) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);
            TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
            };
            HashMap<String, Object> data = objectMapper.readValue(file, typeRef);
            List<Map<String, String>> classes = (List<Map<String, String>>) data.get("classes");
            for (Map<String, String> classroom : classes) {
                if (classroom.get("id").equals(classroomId)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // check student in classroom
    public boolean checkStudentInClass(String studentId, String classId) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);
            TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
            };
            HashMap<String, Object> data = objectMapper.readValue(file, typeRef);
            List<Map<String, String>> classList = (List<Map<String, String>>) data.get("classList");
            for (Map<String, String> classroom : classList) {
                if (classroom.get("classId").equals(classId) && classroom.get("studentId").equals(studentId)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // view classroom
    public void viewClassroom() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);
            TypeReference<Map<String, Object>> typeRef = new TypeReference<Map<String, Object>>() {};
            Map<String, Object> data = objectMapper.readValue(file, typeRef);
            List<Map<String, String>> classes = (List<Map<String, String>>) data.get("classes");
            List<Map<String, String>> classList = (List<Map<String, String>>) data.get("classList");

            System.out.format("%-10s %-15s %-15s %-20s %-20s\n",
                    "ID", "Name", "Lecturer", "Tutor", "Student Count");

            for (Map<String, String> classInfo : classes) {
                String classId = classInfo.get("id");
                String className = classInfo.get("name");
                String lecturerId = classInfo.get("lecturerId");

                // Find lecturer name
                String lecturerName = findLecturerName(lecturerId, data);

                // Find tutor name
                String tutorName = findTutorName(classId, classList, data);

                // Find student count
                int studentCount = countStudentsInClass(classId, classList);

                System.out.format("%-10s %-15s %-15s %-20s %-20s\n",
                        classId, className, lecturerName, tutorName, studentCount);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // helper method to find lecturer name
    private String findLecturerName(String lecturerId, Map<String, Object> data) {
        List<Map<String, String>> lectures = (List<Map<String, String>>) data.get("lectures");
        for (Map<String, String> lecturer : lectures) {
            if (lecturerId.equals(lecturer.get("id"))) {
                return lecturer.get("name");
            }
        }
        return "N/A";
    }

    // helper method to find tutor name
    private String findTutorName(String classId, List<Map<String, String>> classList, Map<String, Object> data) {
        for (Map<String, String> entry : classList) {
            if (classId.equals(entry.get("classId"))) {
                String studentId = entry.get("studentId");
                List<Map<String, String>> students = (List<Map<String, String>>) data.get("students");
                for (Map<String, String> student : students) {
                    if (studentId.equals(student.get("id"))) {
                        return student.get("name");
                    }
                }
            }
        }
        return "N/A";
    }

    // helper method to count students in class
    private int countStudentsInClass(String classId, List<Map<String, String>> classList) {
        int count = 0;
        for (Map<String, String> entry : classList) {
            if (classId.equals(entry.get("classId"))) {
                count++;
            }
        }
        return count;
    }
}