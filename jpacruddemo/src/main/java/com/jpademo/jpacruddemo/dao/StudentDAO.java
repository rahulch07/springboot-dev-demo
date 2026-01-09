package com.jpademo.jpacruddemo.dao;

import com.jpademo.jpacruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    Student updateStudent(Student thStudent);

    void deleteStudent(Integer id);

    List<Student> findAll();
}
