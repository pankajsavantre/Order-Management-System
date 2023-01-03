package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.order.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Modifying
	@Transactional
	@Query("Update Customer set category= :category, discount= :discount, numord= :numord WHERE cid= :cid")
	Integer updatedetails(String category,double discount,int numord,int cid);
	

}
