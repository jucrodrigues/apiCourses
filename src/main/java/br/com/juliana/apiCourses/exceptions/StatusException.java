package br.com.juliana.apiCourses.exceptions;

public class StatusException extends RuntimeException{
  
  public StatusException() {
    super(" Status not found");
  }
}
