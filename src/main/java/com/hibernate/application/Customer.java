package com.hibernate.application;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	
	@Column
	private String customerName;
	
	@OneToMany(mappedBy = "customer")
	private List<Order> orders;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String customerName) {
		super();
		this.customerName = customerName;
	}

	public Customer(String customerName, List<Order> orders) {
		super();
		this.customerName = customerName;
		this.orders = orders;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	
}
