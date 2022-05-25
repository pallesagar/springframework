package com.employee.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.services.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {


	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping("/employess")
	public Employee createEmployee(@RequestBody Employee employee) {
		
		
		return employeeService.createEmployee(employee);
		
	}
}
