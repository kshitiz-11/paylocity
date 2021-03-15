package com.paylocity.benefits.service;

import org.springframework.stereotype.Service;
import static com.paylocity.benefits.config.Constants.DISCOUNT_FOR_NAMES_STARTING_WITH_A;

@Service
public class DiscountWithNameA implements IDiscountWithNameA {


    @Override
    public double calculateDiscount(String name, double cost) {

        if(name.toUpperCase().startsWith("A")){

            cost = cost * ((100 - DISCOUNT_FOR_NAMES_STARTING_WITH_A)/100);
        }
        return cost;
    }
}
