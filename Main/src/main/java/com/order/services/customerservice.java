package com.order.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.model.Customer;
import com.order.repository.CustomerRepository;

@Service
public class customerservice {
	
	@Autowired
	private CustomerRepository repo;
	
	public Customer addCustomer(Customer cust) {
		return this.repo.save(cust);
	}
	
	public List<Customer> getCustomer(){
		return this.repo.findAll();
	}
}
