package com.springboot.firstapp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldContainer {
	//get
	//post
	//put
	//delete
	//Get http world
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hellow World";
	}
}
