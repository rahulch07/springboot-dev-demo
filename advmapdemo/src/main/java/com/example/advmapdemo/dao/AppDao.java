package com.example.advmapdemo.dao;

import com.example.advmapdemo.entity.Instructor;
import com.example.advmapdemo.entity.InstructorDetail;

public interface AppDao {
    void save(Instructor instructor);

    Instructor findById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
