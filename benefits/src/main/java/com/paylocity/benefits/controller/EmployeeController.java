package com.paylocity.benefits.controller;

import com.paylocity.benefits.model.*;
import com.paylocity.benefits.service.EmployeeService;
import com.paylocity.benefits.service.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin
@RestController
public class EmployeeController {

    @Autowired
    private ValidationError validationError;

    @Autowired
    private EmployeeService employeeService;

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @PutMapping("/employee/{id}")
    public ResponseEntity<?> calculateBenefit(@PathVariable Long id, @Valid @RequestBody Employee employee, BindingResult bindingResult){

        ResponseEntity<?> errorMap = validationError.ValidationError(bindingResult);
        if(errorMap!=null) return errorMap;

        if(!id.equals(employee.getId())) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Employee eSave = employeeService.updateEmployee(employee);
        logger.debug("Employee updated with id = " + employee.getId());


        return new ResponseEntity<>(eSave, HttpStatus.OK);
    }


    @GetMapping("employee/{id}")
    public  ResponseEntity<?> getEmployee(@PathVariable Long id){

        Employee employee = employeeService.getEmployeeById(id);
        logger.info("Employee create with id = " + employee.getId());
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }



    @PostMapping("employee/")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult){

        ResponseEntity<?> errorMap = validationError.ValidationError(bindingResult);
        if(errorMap!=null) return errorMap;

        Employee employeeSave = employeeService.saveEmployee(employee);
        logger.debug("Employee create with id = " + employee.getId());
        return new ResponseEntity<>(employeeSave, HttpStatus.CREATED);
    }


}
