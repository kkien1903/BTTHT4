package com.luuthikimyen.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

/**
 * WelcomeController - REST Controller for handling HTTP requests
 * 
 * @RestController: Combines @Controller and @ResponseBody annotations
 * - Automatically converts returned objects to JSON/XML format
 * - Each method's return value is serialized and sent in the response body
 * - Eliminates the need for writing manual serialization code
 */
@RestController
public class WelcomeController {

    /**
     * Câu 1: Welcome endpoint
     * Displays "Welcome to Spring Boot" at /welcome path
     * 
     * @GetMapping: Maps HTTP GET requests to this method
     * @return Simple welcome message as plain text (or JSON object if wrapped)
     */
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring Boot";
    }

    /**
     * Câu 2: REST API returning list of students
     * Returns a list of students in JSON format
     * 
     * @GetMapping: Maps HTTP GET requests to this method
     * @return List of Student objects (automatically converted to JSON array)
     * 
     * Example response:
     * [
     *   {"id": 1, "name": "Nguyễn Văn A", "email": "a@example.com", "gpa": 3.8},
     *   {"id": 2, "name": "Trần Thị B", "email": "b@example.com", "gpa": 3.9}
     * ]
     */
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Nguyễn Văn A", "a@example.com", 3.8));
        students.add(new Student(2, "Trần Thị B", "b@example.com", 3.9));
        students.add(new Student(3, "Phạm Minh C", "c@example.com", 3.7));
        students.add(new Student(4, "Hoàng Thu D", "d@example.com", 3.6));
        return students;
    }

    /**
     * Alternative endpoint returning a single student
     * Demonstrates how @RestController converts a single object to JSON
     */
    @GetMapping("/student")
    public Student getSingleStudent() {
        return new Student(1, "Nguyễn Văn A", "a@example.com", 3.8);
    }
}
