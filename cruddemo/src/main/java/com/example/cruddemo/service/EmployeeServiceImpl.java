package com.example.cruddemo.service;

import com.example.cruddemo.dao.EmployeeDAO;
import com.example.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO empl;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.empl = employeeDAO;
    }

    @Override
    public List<Employee> findAll(){
        return empl.findAll();
    }
}