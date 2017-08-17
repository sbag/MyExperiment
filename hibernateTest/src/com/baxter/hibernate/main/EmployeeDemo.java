package com.baxter.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.baxter.hibernate.entity.ContractEmployee;
import com.baxter.hibernate.entity.Employee;
import com.baxter.hibernate.entity.RegularEmployee;

public class EmployeeDemo {

	public static void main(String[] args) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Employee emp1 = new Employee();
		emp1.setName("Sourav");
		ContractEmployee emp2 = new ContractEmployee();
		emp2.setName("Rajib");
		emp2.setContractDuration(2);
		emp2.setRatePerHour(15.2);
		
		RegularEmployee emp3 = new RegularEmployee();
		emp3.setName("Satya");
		emp3.setBonus(50.5);
		emp3.setSalary(2000.20);
		
		session.persist(emp1);
		session.persist(emp2);
		session.persist(emp3);
		
		t.commit();
		session.close();
		factory.close();

	}

}
