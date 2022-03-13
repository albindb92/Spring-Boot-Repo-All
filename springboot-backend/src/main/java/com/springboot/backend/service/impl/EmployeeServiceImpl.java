package com.springboot.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.backend.exception.ResourceNotFoundException;
import com.springboot.backend.model.Employee;
import com.springboot.backend.repository.EmployeeRepository;
import com.springboot.backend.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepostiory;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepostiory) {
		super();
		this.employeeRepostiory = employeeRepostiory;
	}
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepostiory.save(employee);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepostiory.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		// If else approach
//		Optional<Employee> employee = employeeRepostiory.findById(id);

//		if(employee.isPresent()) {
//			return employee.get();
//		}
//		else {
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}
//		
		// Lambda Approach
		return employeeRepostiory.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		//First check if employee with id exist in database
		Employee existingEmployee = employeeRepostiory.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		employeeRepostiory.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		//check whether employee Exist in database or not
		employeeRepostiory.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		employeeRepostiory.deleteById(id);
		
	}
	

}
