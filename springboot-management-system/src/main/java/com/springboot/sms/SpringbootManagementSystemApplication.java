package com.springboot.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.sms.entity.Student;
import com.springboot.sms.repository.StudentRepository;

@SpringBootApplication
public class SpringbootManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Student student1 =  new Student("Albin","Daniel","albindb.92@gmail.com");
//		studentRepository.save(student1);
//		
//		Student student2 =  new Student("Chris","Daniel","albindb.92@gmail.com");
//		studentRepository.save(student2);
//		
//		Student student3 =  new Student("Test1","Test2","albindb.92@gmail.com");
//		studentRepository.save(student3);
	}

}
