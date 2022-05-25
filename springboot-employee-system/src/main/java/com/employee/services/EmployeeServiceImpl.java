package com.employee.services;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.model.EmployeeEntity;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepo;
	
	

	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}



	@Override
	public Employee createEmployee(Employee employee) {
		EmployeeEntity employeEntity=new EmployeeEntity();
		
		BeanUtils.copyProperties(employee, employeEntity);
		 employeeRepo.save(employeEntity);
		 return employee;
	}

}
