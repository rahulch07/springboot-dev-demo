package com.example.advmapdemo.dao;

import com.example.advmapdemo.entity.Instructor;
import com.example.advmapdemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDao {
    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor){
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail temp = entityManager.find(InstructorDetail.class, id);

        //break bidirection link by setting instructor_detail null for an instructor.
        Instructor temp2 = temp.getInstructor();
        temp.setInstructor(null);

        temp2.setInstructorDetail(null);
        entityManager.remove(temp);
    }
}
