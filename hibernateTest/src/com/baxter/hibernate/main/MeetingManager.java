package com.baxter.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.baxter.manyToMany.Leader;
import com.baxter.manyToMany.Meeting;

public class MeetingManager {

	public static void main(String[] args) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Leader l1 = new Leader("Sourav");
		Leader l2 = new Leader("Saikat");
		
		Meeting m1 = new Meeting("Daily StandUp meeting");
		Meeting m2 = new Meeting("Project Status Update Meeting");
		
		l1.getMeetings().add(m1);
		l1.getMeetings().add(m2);
		
		l2.getMeetings().add(m2);
		
		session.save(l1);
		session.save(l2);
		
		t.commit();
		session.close();
		factory.close();
		
	}

}
