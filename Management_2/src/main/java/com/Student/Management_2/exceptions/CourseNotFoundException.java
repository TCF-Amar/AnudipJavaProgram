package com.Student.Management_2.exceptions;

@SuppressWarnings("serial")
public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(String courseName) {
        super("❌ Course not found with name: " + courseName);
    }
}
