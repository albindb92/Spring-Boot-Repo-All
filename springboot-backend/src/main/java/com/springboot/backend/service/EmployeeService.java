package com.springboot.backend.service;

import java.util.List;

import com.springboot.backend.model.Employee;

public interface EmployeeService {
	//First param employee,List<Employee> in each are the response types in service interface module
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee,long id);
	void deleteEmployee(long id);
	
}
