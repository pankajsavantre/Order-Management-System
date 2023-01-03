package com.order.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="category")
@NoArgsConstructor
@Getter 
@Setter
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int caid;
	private String category;
}
