package com.order.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="orders")
@NoArgsConstructor
@Getter 
@Setter
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int oid;
	
	private String item;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="cid")
	private Customer cid;

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", item=" + item + ", cid=" + cid + "]";
	}
	
	
	
}
