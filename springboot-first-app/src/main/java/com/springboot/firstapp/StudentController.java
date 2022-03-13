package com.springboot.firstapp;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController Handle web request
@RestController
public class StudentController {

	//Student- is the bean
	//return a json object to client , the conversion happens internally as sping mvc uses jackson library (MappingJackson2httpconverte)
	//that converts java object to jsob object
	@GetMapping("/student")
	public Student getStudent() {
		return new Student("albin","daniel");
	}
	
	//List of students send to client
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student("CHRIS","JOHN"));
		students.add(new Student("TEST","JTEST"));
		students.add(new Student("ASD","ASD"));
		students.add(new Student("ASD","FAS"));
		students.add(new Student("FS","FS"));
		return students;
	}

}
