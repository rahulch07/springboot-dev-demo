package com.example.cruddemo.rest;

import com.example.cruddemo.dao.EmployeeDAO;
import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService empl;
    public EmployeeController(EmployeeService employeeService) {
        this.empl = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        List<Employee> lst = this.empl.findAll();
        return lst;
    }
}
