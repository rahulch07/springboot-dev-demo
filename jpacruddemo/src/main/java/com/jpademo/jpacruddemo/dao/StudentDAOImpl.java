package com.jpademo.jpacruddemo.dao;

import com.jpademo.jpacruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public List<Student> findAll(){
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        return  theQuery.getResultList();
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
