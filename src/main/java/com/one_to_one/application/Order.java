package com.one_to_one.application;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {

	@Id
	private int orderId;
	
	@Column
	private String productName;

	public Order() {}
	
	public Order(int orderId, String productName) {
		super();
		this.orderId = orderId;
		this.productName = productName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}
