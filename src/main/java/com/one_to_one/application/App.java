package com.one_to_one.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        org.hibernate.Transaction ts = session.beginTransaction();
        
        
        Order o1 = new Order(1, "Shoes");
        session.save(o1);
        
        ts.commit();
        factory.close();
    }
}
