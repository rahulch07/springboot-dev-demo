package com.jpademo.jpacruddemo;

import com.jpademo.jpacruddemo.dao.StudentDAO;
import com.jpademo.jpacruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpacruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpacruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Generating Student...");
		Student tempStudent = new Student("Rahul", "Chougule", "chouguler310@gmail.com");

		System.out.println("saving student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved students id: " + tempStudent.getId());


	}

}
