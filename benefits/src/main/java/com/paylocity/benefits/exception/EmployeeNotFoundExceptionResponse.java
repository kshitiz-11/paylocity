package com.paylocity.benefits.exception;

public class EmployeeNotFoundExceptionResponse {
    private String employeeNotFound;

    public EmployeeNotFoundExceptionResponse(String employeeNotFound) {
        this.employeeNotFound = employeeNotFound;
    }

    public String getEmployeeNotFound() {
        return employeeNotFound;
    }

    public void setEmployeeNotFound(String employeeNotFound) {
        this.employeeNotFound = employeeNotFound;
    }
}
