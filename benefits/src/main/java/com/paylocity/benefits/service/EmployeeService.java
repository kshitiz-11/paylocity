package com.paylocity.benefits.service;

import com.paylocity.benefits.model.Employee;
import com.paylocity.benefits.model.EmployeeFinance;
import com.paylocity.benefits.repository.EmployeeRepository;
import exception.EmployeeNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import static com.paylocity.benefits.config.Constants.SALARY;
import static com.paylocity.benefits.config.Constants.NO_OF_PAYCHECKS;

/**
 * The EmployeeService class holds the business logic to
 * deduct a portion of cost of benefit from employee's paycheck
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CalcutatePreviewCost calcutatePreviewCost;


    Logger logger = LoggerFactory.getLogger(EmployeeService.class);


    /**
     * This method is used to calculate the deductions from employee's salary
     * @param employee The model object which contains the information of employee and it's dependents
     * @return employee The model object which contains the information of employee, it's dependents and employee's finance details calculated
     */

    public EmployeeFinance generateOrUpdateEmployeeFinance(Employee employee){

        EmployeeFinance employeeFinance;
        if(employee.getEmployeeFinance() == null){
            employeeFinance = new EmployeeFinance();
        }
        else {
            employeeFinance = employee.getEmployeeFinance();
        }

        double yearlyDeduction = calculateYearlyDeductions(employee);
        double paycheckDeduction = yearlyDeduction / NO_OF_PAYCHECKS;
        double employeeReceives = SALARY - paycheckDeduction;

        employeeFinance.setYearDeductions(String.valueOf(yearlyDeduction));
        employeeFinance.setPaycheckDeduction(String.valueOf(paycheckDeduction));
        employeeFinance.setEmployeeRecieves(String.valueOf(employeeReceives));
        return employeeFinance;
    }



    public Employee saveEmployee(Employee employee){
        EmployeeFinance employeeFinance = generateOrUpdateEmployeeFinance(employee);
        employee.setEmployeeFinance(employeeFinance);
        Employee saveEmployee = employeeRepository.save(employee);
        logger.info("Employee succesfully  created with id = " + saveEmployee.getId());
        return saveEmployee;
    }


    public Employee getEmployeeById(Long id){
        Optional<Employee> employee  = employeeRepository.findById(id);
        System.out.println("Employee=" + employee);
        if(!employee.isPresent()) {
            logger.info("Employee with id = " + id + " does not exist");
             throw new EmployeeNotFoundException("Employee Id =" + id + " does not exit");
        }
        logger.info("Employee found with id = " + id);
        return employee.get();
    }


    public Employee updateEmployee(Employee employee){
        EmployeeFinance employeeFinance = generateOrUpdateEmployeeFinance(employee);
        employee.setEmployeeFinance(employeeFinance);
        Employee eUpdate= getEmployeeById(employee.getId());
        Employee uEmployee = employeeRepository.save(employee);
        logger.info("employee succesfully updated with id = " + eUpdate.getId());
        return uEmployee;
    }



    public double calculateYearlyDeductions(Employee employee){
        calcutatePreviewCost.setEmployee(employee);
        double  cost = calcutatePreviewCost.calculate();
        return cost;
    }

}
