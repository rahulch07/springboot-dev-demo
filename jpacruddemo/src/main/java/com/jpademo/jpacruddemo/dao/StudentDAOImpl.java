package com.jpademo.jpacruddemo.dao;

import com.jpademo.jpacruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id){
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public Student updateStudent(Student theStudent){
        return entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id){
        Student temp = entityManager.find(Student.class, id);
         entityManager.remove(temp );
    }
}
