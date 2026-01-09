package com.jpademo.jpacruddemo;

import com.jpademo.jpacruddemo.dao.StudentDAO;
import com.jpademo.jpacruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpacruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpacruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
//			createStudent(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);

			findAll(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {
		Student stud = studentDAO.findById(3);

		stud.setFirstName("Alex1");

		Student newStud =  studentDAO.updateStudent(stud);
		System.out.println("Updated Student: "+ newStud);
	}

	private void deleteStudent(StudentDAO studentDAO){
		studentDAO.deleteStudent(3);
	}

	private void createStudent(StudentDAO studentDAO) {

		//create student
		System.out.println("Generating Student...");
		Student tempStudent = new Student("Alex", "Doe", "alex@gmail.com");

		System.out.println("saving student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved students id: " + tempStudent.getId());

		//findById
		System.out.println("finding student");
		Student student = studentDAO.findById(tempStudent.getId());
		System.out.println("Student: " + student);

	}

	private void findAll(StudentDAO studentDAO){
		List<Student> lst = studentDAO.findAll();
		System.out.println("All Students list: "+ lst);
	}

}
