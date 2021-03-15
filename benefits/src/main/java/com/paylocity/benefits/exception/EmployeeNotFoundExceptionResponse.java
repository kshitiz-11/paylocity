package com.paylocity.benefits.exception;

public class EmployeeNotFoundExceptionResponse {

    private String NotFound;

    public EmployeeNotFoundExceptionResponse(String projectNotFound) {
        this.NotFound = projectNotFound;
    }

    public String getProjectNotFound() {
        return NotFound;
    }

    public void setProjectNotFound(String projectNotFound) {
        this.NotFound = projectNotFound;
    }
}
