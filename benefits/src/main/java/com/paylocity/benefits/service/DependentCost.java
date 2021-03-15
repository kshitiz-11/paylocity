package com.paylocity.benefits.service;

import com.paylocity.benefits.model.Dependent;
import com.paylocity.benefits.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.paylocity.benefits.config.Constants.COST_OF_DEPENDENT;

@Service
public class DependentCost implements ICalculateRule {

    @Autowired
    private IDiscountWithNameA iDiscountWithNameA;

    public DependentCost(IDiscountWithNameA iDiscountWithNameA) {
        this.iDiscountWithNameA = iDiscountWithNameA;
    }

    @Override
    public double calculate(Employee employee, double current) {



        for (Dependent dependent : employee.getDependentList()
             ) {

            double cost = COST_OF_DEPENDENT;
            cost = iDiscountWithNameA.calculateDiscount(dependent.getName(), cost);
            current = current + cost;
            
        }
        return current;
    }
}
