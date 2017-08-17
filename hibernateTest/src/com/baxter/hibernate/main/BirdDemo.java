package com.baxter.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.baxter.hibernate.entity.Bird;
import com.baxter.hibernate.entity.Parrot;

public class BirdDemo {

	public static void main(String[] args) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Bird bird = new Bird();
		bird.setName("cuckoo");
		Parrot parrot = new Parrot();
		parrot.setName("Priya");
		parrot.setColor("Green");
		parrot.setCanSing(true);
		
		session.persist(bird);
		session.persist(parrot);
		
		t.commit();
		session.close();
		factory.close();

	}

}
