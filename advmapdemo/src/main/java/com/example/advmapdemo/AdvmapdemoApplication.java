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
			// create Instructor
//			this.createInstructor(appDao);

			//fetch instructor by id
//			this.fetch(appDao);

			//fetch instructor_detail by id
//			this.fetchInstructorDetailById(appDao);

			//delete instructor detail and also cascade instructor
			this.deleteInstructorDetailById(appDao);
		};
	}

	private void deleteInstructorDetailById(AppDao appDao) {
		appDao.deleteInstructorDetailById(4);
		System.out.println("Deleted Instructor Detail: " + 4);
	}

	private void fetchInstructorDetailById(AppDao appDao) {
		InstructorDetail temp = appDao.findInstructorDetailById(1);
		System.out.println("Instructor Detail"+temp);
		System.out.println("Instructor"+temp.getInstructor());
	}

	private void fetch(AppDao appDao) {
		Instructor temp = appDao.findById(2);
		System.out.println("Instructor: " + temp);
		System.out.println("Instructor Details: " + temp.getInstructorDetail());
	}

	private void createInstructor(AppDao appDao) {
		//create Instructor
		Instructor temp = new Instructor("Uday", "Singh", "uday@gmail.com");

		//create instructor_details
		InstructorDetail temp2 = new InstructorDetail("youtube.com", "coding");

		temp.setInstructorDetail(temp2);

		System.out.println("The Instructor: " + temp);
		appDao.save(temp);
	}

}
