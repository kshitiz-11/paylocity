package com.paylocity.benefits.service;

import com.paylocity.benefits.model.Employee;

public interface ICalculateRule {

    double calculate(Employee employee, double current);
}
