package com.hibernate.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    	Order o1 = new Order();
    	Order o2 = new Order();
    	List<Order> orders = new ArrayList<Order>(Arrays.asList(o1, o2)) ;
    	Customer c1 = new Customer("John Doe");
    	Customer c2 = new Customer("James Smith");
    	Customer c3 = new Customer("Jessica Jones");
    	Customer c4 = new Customer("Jessy Custer");
    	Customer c5 = new Customer("Jack Ryan");
    	Customer c6 = new Customer("Elenor Shellstrop");

    	// SET 
    	c1.setOrders(orders);
    	
    	// SET 
    	o1.setCustomer(c1);
    	o2.setCustomer(c2);
    	
    	// SAVE
    	session.save(o1);
    	session.save(o2);
    	session.save(c1);
    	session.save(c1);
    	session.save(c2);
    	session.save(c3);
    	session.save(c4);
    	session.save(c5);
    	session.save(c6);

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
