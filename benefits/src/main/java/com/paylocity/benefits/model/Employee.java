package com.paylocity.benefits.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Dependent> dependentList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private EmployeeFinance employeeFinance;




    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dependent> getDependentList() {
        return dependentList;
    }

    public void setDependentList(List<Dependent> dependentList) {
        this.dependentList = dependentList;
    }

    public EmployeeFinance getEmployeeFinance() {
        return employeeFinance;
    }

    public void setEmployeeFinance(EmployeeFinance employeeFinance) {
        this.employeeFinance = employeeFinance;
    }


}
