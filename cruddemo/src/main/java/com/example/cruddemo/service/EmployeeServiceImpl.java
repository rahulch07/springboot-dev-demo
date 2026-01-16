package com.example.cruddemo.service;

import com.example.cruddemo.dao.EmployeeDAO;
import com.example.cruddemo.dao.EmployeeDAOImpl;
import com.example.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
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

    @Override
    public Employee findById(Integer id){
        return empl.findById(id);
    }

    @Override
    @Transactional
    public Employee create(Employee employee){
        return empl.create(employee);
    }

    @Override
    @Transactional
    public Employee update(Employee employee){
        return empl.update(employee);
    }

    @Override
    @Transactional
    public void delete(Integer id){
        empl.delete(id);
    }
}