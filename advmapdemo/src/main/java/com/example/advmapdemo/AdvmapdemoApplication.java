package com.example.advmapdemo;

import com.example.advmapdemo.dao.AppDao;
import com.example.advmapdemo.entity.Instructor;
import com.example.advmapdemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvmapdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvmapdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner -> {
			this.createInstructor(appDao);
		};
	}

	private void createInstructor(AppDao appDao) {
		//create Instructor
		Instructor temp = new Instructor("Rahul", "Chougule", "rahul@gmail.com");

		//create instructor_details
		InstructorDetail temp2 = new InstructorDetail("youtube.com", "coding");

		temp.setInstructorDetail(temp2);

		System.out.println("The Instructor: " + temp);
		appDao.save(temp);
	}

}
