package com.hibernate.application;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "Store")
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int storeId;
	
	@Column(length = 100, name = "store_name")
	private String storeName;
	
	@Column(length = 100, name = "street")
	private String street;
	
	@Column(length = 100, name = "city")
	private String city;
	
	
	@Column(name = "is_open")
	private boolean isOpen;
	
	@Transient
	private double x;
	
	@Column(name = "added_date")
	@Temporal(TemporalType.DATE)
	private Date addedDate;
	
	@Lob
	@Column(name = "store_image")
	private byte[] storeImage;

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	Store() {
		
	}
	public Store(int storeId, String street, String storeName, String city, boolean isOpen, double x, Date startDate, byte[] storeImage) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.street = street;
		this.city = city;
		this.isOpen = isOpen;
		this.x = x;
		this.addedDate = startDate;
		this.storeImage = storeImage;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Date getStartDate() {
		return addedDate;
	}

	public void setStartDate(Date startDate) {
		this.addedDate = startDate;
	}

	public byte[] getStoreImage() {
		return storeImage;
	}

	public void setStoreImage(byte[] storeImage) {
		this.storeImage = storeImage;
	}
	
}
