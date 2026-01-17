package com.example.cruddemo.service;

import com.example.cruddemo.dao.EmployeeRepository;
import com.example.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository empl;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.empl = employeeRepository;
    }

    @Override
    public List<Employee> findAll(){
        return empl.findAll();
    }

    @Override
    public Employee findById(Integer id){
        Optional<Employee> result = empl.findById(id);
        Employee emp = null;
        if(result.isPresent()){
            emp = result.get();
        }else {
            throw new RuntimeException("Not found employee with id: " + id);
        }
        return emp;
    }

    @Override
    @Transactional
    public Employee create(Employee employee){
        return empl.save(employee);
    }

    @Override
    @Transactional
    public Employee update(Employee employee){
        return empl.save(employee);
    }

    @Override
    @Transactional
    public void delete(Integer id){
        empl.deleteById(id);
    }
}