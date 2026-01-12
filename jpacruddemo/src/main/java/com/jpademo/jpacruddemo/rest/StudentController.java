package com.jpademo.jpacruddemo.rest;

import com.jpademo.jpacruddemo.dao.StudentDAO;
import com.jpademo.jpacruddemo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    StudentDAO std;

    public StudentController(StudentDAO studentDAO){
        this.std = studentDAO;
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
//        List<Student> lst = new ArrayList<>();
//        lst.add(new Student("Rahul1", "Chougule1", "email1@example.com"));
//        lst.add(new Student("Rahul2", "Chougule2", "email2@example.com"));
//        lst.add(new Student("Rahul3", "Chougule3", "email3@example.com"));
        List<Student> nw = std.findAll();
        System.out.println("Returned list: "+ nw);
        return nw;
    };

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){
//        List<Student> lst = new ArrayList<>();
//        Student temp1 = new Student("Rahul1", "Chougule1", "email1@example.com");
//        std.save(temp1);
//        Student temp2 = new Student("Rahul2", "Chougule2", "email2@example.com");
//        std.save(temp1);
//        Student temp3 = new Student("Rahul3", "Chougule3", "email3@example.com");
//        std.save(temp1);

        Student nw = std.findById(id);
        System.out.println("Returned Student: "+ nw);

        return nw;
    };
}
