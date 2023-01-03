package com.order.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="customer")
@NoArgsConstructor
@Getter 
@Setter
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String name;
	private String email;

	
	private String category;

	
	private double discount;
	private int numord;
	
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", email=" + email + ", category=" + category + ", discount="
				+ discount + ", numord=" + numord + "]";
	}

	public Customer(int i, String string, String string2, String string3, double d, int j) {
		// TODO Auto-generated constructor stub
	}
	
}
