package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.order.model.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{
	
	@Query(value="SELECT COUNT(*) FROM orders c WHERE c.cid=?1",nativeQuery = true)
	public int getdetails(int cid);
	
	
	
}
