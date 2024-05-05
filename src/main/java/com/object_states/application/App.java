package com.object_states.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory = new Configuration().configure().buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction tsx = session.beginTransaction();
    	Customer c1 = new Customer("John Doe");
    	session.save(c1);
    	tsx.commit();

    	Customer c2 = new Customer();
    	c2.setCustomerName("James Smith"); // Customer c2 won't be saved. Transaction is already commited.

    	session.save(c2);
    	factory.close();
    	
    }
}
