package com.customer.sevices;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.customer.entity.Customer;
import com.customer.entity.CustomerModel;
import com.customer.repository.CustomerRepository;

@Service
public class CustomerImpl implements CustomerService{

	
	private CustomerRepository repo;
	
	
	
	public CustomerImpl(CustomerRepository repo) {
	
		this.repo = repo;
	}



	@Override
	public CustomerModel saveCustomer(CustomerModel customer) {
		Customer employeEntity=new Customer();
		BeanUtils.copyProperties(customer, employeEntity);
		 repo.save(employeEntity);
		 return customer;
		
	}

}
