package com.paylocity.benefits.service;

import com.paylocity.benefits.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.paylocity.benefits.config.Constants.COST_OF_BENEFITS;

@Service
public class CostPerYearRuleCalculation implements ICalculateRule {

    @Autowired
    private IDiscountWithNameA iDiscountWithNameA;

    public CostPerYearRuleCalculation(IDiscountWithNameA iDiscountWithNameA) {
        this.iDiscountWithNameA = iDiscountWithNameA;
    }

    @Override
    public double calculate(Employee employee, double current) {

        double cost = COST_OF_BENEFITS;
        cost = iDiscountWithNameA.calculateDiscount(employee.getName(), cost);
        return current + cost;
    }


}
