package com.springboot.sms.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;

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
		
		
//		http
//		.authorizeRequests()
//		.antMatchers("/user/**").permitAll()
//		.antMatchers("/admin/**").denyAll()
//		.and()
//		.httpBasic();
		
		
		http
		.authorizeRequests()
		.antMatchers("/user/home").permitAll()
		.antMatchers("/user/dashboard").authenticated()
		.and()
		.httpBasic();
	}
	
	//Configure  multiple user for authentication - by default spring gives usernam as user and password can be taken from spring console.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
		auth.inMemoryAuthentication()
		.withUser("albin").password("12345").authorities("admin")
		.and()
		.withUser("user").password("12345").authorities("user")
		.and()
		.passwordEncoder(NoOpPasswordEncoder.getInstance());
		
	}
	
	
}
