package com.baxter.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.baxter.oneToMany.Department;
import com.baxter.oneToMany.Student;

public class StudentDepartmentDemo {

	public static void main(String[] args) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Set<Student> studentSet = new HashSet<Student>();
		
		Department dept1= new Department();
		dept1.setDeptName("Arts");
		Student student1 = new Student();
		student1.setStuName("sourav");
		student1.setStuEmail("souravbag6@gmail.com");
		student1.setDepartment(dept1);
		
		Student student2 = new Student();
		student2.setStuName("saikat");
		student2.setStuEmail("saikatbag@gmail.com");
		student2.setDepartment(dept1);
		
		studentSet.add(student1);
		studentSet.add(student2);
				
		dept1.setStudents(studentSet);
		
		session.save(dept1);
		t.commit();
		session.close();
		factory.close();
		
		
	}

}
