package com.springboot.sms.HomeController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class HomeController {

	@GetMapping("/home")
	public String home() {
		return "home page";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "This is dashboard";
	}
}

