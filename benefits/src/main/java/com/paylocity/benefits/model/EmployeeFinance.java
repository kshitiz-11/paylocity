package com.paylocity.benefits.model;


import javax.persistence.*;

@Entity
public class EmployeeFinance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String yearDeductions;

    private String paycheckDeduction;

    private String employeeRecieves;

    public EmployeeFinance() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYearDeductions() {
        return yearDeductions;
    }

    public void setYearDeductions(String yearDeductions) {
        this.yearDeductions = yearDeductions;
    }

    public String getPaycheckDeduction() {
        return paycheckDeduction;
    }

    public void setPaycheckDeduction(String paycheckDeduction) {
        this.paycheckDeduction = paycheckDeduction;
    }

    public String getEmployeeRecieves() {
        return employeeRecieves;
    }

    public void setEmployeeRecieves(String employeeRecieves) {
        this.employeeRecieves = employeeRecieves;
    }
}
