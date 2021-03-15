package com.paylocity.benefits.service;

import com.paylocity.benefits.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatePreviewStrategy implements ICalculatePreviewStrategy{

    @Autowired
    private List<ICalculateRule> rules;

    public CalculatePreviewStrategy(List<ICalculateRule> rules) {
        this.rules = rules;
    }


    @Override
    public double calculate(Employee employee) {

        double result = 0.0;

        for (ICalculateRule iCalculateRule:rules
             ) {
            result = iCalculateRule.calculate(employee, result);
        }
        return result;
    }
}
