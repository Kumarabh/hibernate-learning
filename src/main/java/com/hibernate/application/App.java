package com.hibernate.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory = new Configuration().configure().buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction tsx = session.beginTransaction();
    	
    	// CREATE 
    	Product p1 = new Product("Shoes", "Adidas", "1200.00", "This shoe is awesome.");
    	Product p2 = new Product("T-Shirt", "Puma", "1500.00", "This T-shirt is awesome.");
    	Order o1 = new Order();
    	List<Order> orders = new ArrayList<Order>(Arrays.asList(o1)) ;
    	List<Product> products = new ArrayList<Product>(Arrays.asList(p1, p2));
    	Customer c1 = new Customer("John Doe");

    	
    	// SET 
    	p1.setOrders(orders);
    	p2.setOrders(orders);
    	o1.setProducts(products);
    	o1.setCustomer(c1);
    	c1.setOrders(orders);

    	
    	// SAVE
    	session.save(p1);
    	session.save(p2);
    	session.save(o1);
    	session.save(c1);

    	// ------------------------------- CREATE QUERY 
    	Query<Customer> query = session.createQuery("FROM Customer", Customer.class);
    	
    	
    	// ------------------------------- SET PAGINATION
    	query.setFirstResult(0); // Start from: index 0
    	query.setMaxResults(3); // Page size: 3
    	
    	
    	// ------------------------------- GET RESULT 
    	List<Customer> customerList = query.list();
    	
    	for(Customer customer: customerList) {
    		System.out.println(customer.getCustomerName());
    		
    	}
    	
    	tsx.commit();
    	factory.close();
    	
    }
}
