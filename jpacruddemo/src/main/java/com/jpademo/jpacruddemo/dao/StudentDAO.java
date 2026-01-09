package com.jpademo.jpacruddemo.dao;

import com.jpademo.jpacruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    Student updateStudent(Student thStudent);

    void deleteStudent(Integer id);
}
