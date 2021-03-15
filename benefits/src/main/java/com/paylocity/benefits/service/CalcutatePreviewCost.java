package com.paylocity.benefits.service;

import com.paylocity.benefits.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CalcutatePreviewCost {

    @Autowired
    private ICalculatePreviewStrategy strategy;

    public Employee employee;

    public CalcutatePreviewCost(ICalculatePreviewStrategy strategy) {
        this.strategy = strategy;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double calculate(){

        double result = strategy.calculate(employee);
        return result;

    }
}
