package com.baxter.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.baxter.manyToOne.Category;
import com.baxter.manyToOne.Product;

public class ProductManager {

	public static void main(String[] args) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Set<Product> productSet = new HashSet<Product>();
		
		Category cat1 = new Category("Computer");
		Category cat2 = new Category("Furniture");
		
		Product p1 = new Product("Dell",200.00,cat1);
		Product p2 = new Product("HP",150.00,cat1);
		Product p3 = new Product("Table",350.50,cat2);
	
		session.save(p1);
		session.save(p2);
		session.save(p3);
		t.commit();
		session.close();
		factory.close();
				
	}

}
