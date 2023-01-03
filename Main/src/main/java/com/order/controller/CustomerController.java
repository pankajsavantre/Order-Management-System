package com.order.controller;





import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.model.Customer;
import com.order.model.Order;
import com.order.repository.CustomerRepository;
import com.order.repository.OrderRepository;
import com.order.services.customerservice;


@RestController
@RequestMapping("/api")
public class CustomerController {
	
	
	
	
	public int cid,n;
	String category="Regular";
	
	@Autowired
	private customerservice custservice;
	
	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private OrderRepository ordrepo;


	
	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> CreateCust(@RequestBody Customer cust){
		
		cust.setCategory(category);
		cust.setDiscount(0);
		cust.setNumord(n);
		Customer c=this.custservice.addCustomer(cust);
		return new ResponseEntity<>(c,HttpStatus.CREATED);
	}

	@GetMapping("/getcustomer")
	public ResponseEntity<List<Customer>> GetAll(){
		
		return new ResponseEntity<>(this.custservice.getCustomer(),HttpStatus.OK);
	}
	
	
	
//	Order Controller
	@PutMapping("/placeorder")
	public ResponseEntity<String> PlaceOrder(@RequestBody Order o){
		
		cid=o.getCid().getCid();
		 n=this.ordrepo.getdetails(cid);
		System.out.println(n);
		
		System.out.println(cid);
		
	
		
		if(n==10) {
			repo.updatedetails("Gold",0.1,n, cid);
			return new ResponseEntity<>(SendEmail(),HttpStatus.CREATED);
			
		}
		else if(n==20) {
			repo.updatedetails("Platinum",0.2,n, cid);
			return new ResponseEntity<>(SendEmail(),HttpStatus.CREATED);
		}
		this.ordrepo.save(o);
		return new ResponseEntity<>("Total => "+ n +" Order Placed",HttpStatus.CREATED);
	}
	
	public String SendEmail() {
		return "Sent Mail";
	}
}
