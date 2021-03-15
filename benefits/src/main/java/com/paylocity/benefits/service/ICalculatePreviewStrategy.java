package com.paylocity.benefits.service;

import com.paylocity.benefits.model.Employee;

public interface ICalculatePreviewStrategy {

    double calculate(Employee employee);
}
