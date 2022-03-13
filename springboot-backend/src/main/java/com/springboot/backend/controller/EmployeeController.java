package com.springboot.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.Employee;
import com.springboot.backend.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	//build create employee REST Api
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	//build all employee Rest Api
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	//	http:localhost:8090/api/employees/1
	@GetMapping("{id}")
	//get employee By id Rest Api
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}
	
	
	//	http:localhost:8090/api/employees/1
	//build Update employee Rest Api
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployeeId(@PathVariable("id") long employeeId,
				@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,employeeId), HttpStatus.OK);
	}
	
//	http:localhost:8090/api/employees/1
	@DeleteMapping("{id}")
	//build delete employee rest api
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long employeeId){
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<String>("Employee Deleted Successfully!.",HttpStatus.OK);
	}
}
