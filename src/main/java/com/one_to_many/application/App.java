package com.one_to_many.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    	Session session = sessionFactory.openSession();
    	Transaction tsx = session.beginTransaction();
    	
    	// Set data
//    	Cart c1 = new Cart();
//
//    	Product p1  = new Product("Shoes", "Adidas", 1200);
//    	Product p2  = new Product("T-Shirt", "Puma", 1400);
//    	List<Product> productsList = new ArrayList<Product>(Arrays.asList(p1, p2));
//
//    	p1.setCart(c1);
//    	p2.setCart(c1);
//    	c1.setProducts(productsList);
//    	
//    	session.save(p1);
//    	session.save(p2);
//    	session.save(c1);
    	
    	// Get data
    	
    	Cart cart = (Cart)session.get(Cart.class, 3);
    	List<Product> dbProducts = cart.getProducts();
    	for(Product p: dbProducts) {
    		System.out.println(p.getProductName());
    	}
    	
    	tsx.commit();
    	sessionFactory.close();

    }
}
