package com.hibernate.application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static void setStoreData() throws IOException {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        org.hibernate.Transaction ts = session.beginTransaction();
        
        FileInputStream fs = new FileInputStream("src/main/java/pic.png");
        byte[] fileBytes = new byte[fs.available()];
        fs.read(fileBytes);
        Store s1 = new Store(0, "Street 3", "Enterprise 3", "New Delhi", true, 0, new Date(), null);
        
        session.save(s1);
        ts.commit();
        factory.close();
	}
	
	private static void getStoreData() throws IOException {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Store s1 = session.get(Store.class, 2);
		System.out.println(s1.getStoreName());
		
		factory.close();
		
	}
	
    public static void main( String[] args ) throws IOException 
    {
//    	setStoreData();
        getStoreData();
    }
}
