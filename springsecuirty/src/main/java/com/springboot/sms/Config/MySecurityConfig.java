package com.springboot.sms.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// TO AUTHENTICATE ONY FEW ENDPOINTS
//			http
//			.authorizeRequests()
//			.antMatchers("/dashboard").authenticated() // Protected
//			.antMatchers("/home").permitAll() //Not protected
//			.and()
//			.formLogin()
//			.and()
//			.httpBasic();
		
		// To deny all http request- EXAMPLE ADMIN ENDPOINTS CALLS SHOULD NOT BE ACCESSIBLE BY USER
//		http
//		.authorizeRequests()
//		.anyRequest()
//		.denyAll()
//		.and()
//		.httpBasic();
		
		// To deny all http request- EXAMPLE ADMIN ENDPOINTS CALLS SHOULD NOT BE ACCESSIBLE BY USER
		
		
		http
		.authorizeRequests()
		.antMatchers("/user/**").permitAll()
		.antMatchers("/admin/**").denyAll()
		.and()
		.httpBasic();
	}
}
