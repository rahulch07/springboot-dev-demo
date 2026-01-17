package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    public Employee findById(Integer id);

    public Employee create(Employee employee);

    public Employee update(Employee employee);

    public void delete(Integer id);
}
