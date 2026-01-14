package com.example.cruddemo.rest;

import com.example.cruddemo.dao.EmployeeDAO;
import com.example.cruddemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    EmployeeDAO empl;
    public EmployeeController(EmployeeDAO employeeDAO) {
        this.empl = employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        List<Employee> lst = this.empl.findAll();
        return lst;
    }
}
