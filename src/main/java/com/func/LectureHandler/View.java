package com.func.LectureHandler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class View {
    public static final String filePath = "C:\\Users\\ACER\\Documents\\Course\\Advance Programming\\Assignment 2\\Project\\FAP\\src\\main\\java\\service\\data.json";

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
}
