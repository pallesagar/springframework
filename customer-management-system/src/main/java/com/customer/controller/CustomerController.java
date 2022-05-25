package com.customer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.entity.CustomerModel;
import com.customer.sevices.CustomerService;

@RestController
@RequestMapping("api/v1")
public class CustomerController {

	private final CustomerService customerrepo;
	
	public CustomerController(CustomerService customer) {
		this.customerrepo = customer;
	}
	@PostMapping("/customer")
	public CustomerModel saveCustomer(@RequestBody CustomerModel customer) {
		
		return customerrepo.saveCustomer(customer);
		
	}
}
