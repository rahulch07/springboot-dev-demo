package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements  EmployeeDAO{

    EntityManager em;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.em = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = em.createQuery("From Employee", Employee.class);

        List<Employee> lst = theQuery.getResultList();

        return lst;
    }
}
