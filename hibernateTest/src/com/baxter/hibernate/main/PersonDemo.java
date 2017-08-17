package com.baxter.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.baxter.oneToMany.Person;
import com.baxter.oneToMany.Phone;

public class PersonDemo {

	public static void main(String[] args) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Person p1 = new Person();
		p1.setPersonName("Sourav");
		Phone ph1 = new Phone();
		ph1.setPhoneNumber("123456789");
		ph1.setPerson(p1);
		Phone ph2 = new Phone();
		ph2.setPhoneNumber("012345");
		ph2.setPerson(p1);
		Set<Phone> phList = new HashSet<Phone>();
		phList.add(ph1);
		phList.add(ph2);
		
		p1.setPhoneNumbers(phList);
		session.save(p1);
		t.commit();
		session.close();
		factory.close();
		

	}

}
