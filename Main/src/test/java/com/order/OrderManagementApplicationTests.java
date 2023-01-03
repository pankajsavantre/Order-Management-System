package com.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.order.model.Customer;
import com.order.repository.CustomerRepository;
import com.order.services.customerservice;


@SpringBootTest
class OrderManagementApplicationTests {

	@Autowired
	private customerservice service;
	
	@MockBean
	private CustomerRepository repo;
	
//	Getting Size
	
	@Test
	public void getCustomer() {
		when(repo.findAll()).thenReturn(Stream
				.of(new Customer(1,"jhon","ps@gmail.com","Regular",0.1,2)).collect(Collectors.toList()));
		assertEquals(1,service.getCustomer().size());
	}
	
//Saving User
	
	@Test
	public void saveCustomer() {
		Customer customer=new Customer(1,"jhon","ps@gmail.com","Regular",0.1,2);
		when(repo.save(customer)).thenReturn(customer);
		assertEquals(customer, service.addCustomer(customer));
		
	}

}
