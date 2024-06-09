package br.com.juliana.apiCourses.exceptions;


public class CourseFoundException extends RuntimeException{

    public CourseFoundException() {
        super("Course not found");
    }
}
