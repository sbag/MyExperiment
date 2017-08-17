package com.hibernate.ehcache;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();

		session.beginTransaction();

		Country country = null;

		country = (Country) session.load(Country.class, 1l);
		
		System.out.println("Country from the Database => "+country);
		System.out.println();

		System.out.println("Going to print Country *** from First Level Cache");
		// second time loading same entity from the first level cache
		country = (Country) session.load(Country.class, 1l);
		System.out.println(country);
		
		// removing country object from the first level cache.
		session.evict(country);
		System.out.println("Object removed from the First Level Cache");
		System.out.println();
		System.out
				.println("Going to print Country *** from Second level Cache");
		country = (Country) session.load(Country.class, 1l);
		System.out.println(country);
		session.getTransaction().commit();

		// loading object in another session
		Session session2 = factory.openSession();
		session2.beginTransaction();
		System.out.println();
		System.out
				.println("Printing Country *** from Second level Cache in another session");
		country = (Country) session2.load(Country.class, 1l);
		System.out.println(country);
		session2.getTransaction().commit();
		/*session.close();
		session2.close();
		factory.close();*/

	}
}
