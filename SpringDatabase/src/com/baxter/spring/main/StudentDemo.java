package com.baxter.spring.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.baxter.spring.beans.Student;
import com.baxter.spring.dao.StudentDao;

public class StudentDemo {

	public static void main(String args[]) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.xml");
		StudentDao dao = (StudentDao) context.getBean("studentDao");
		try {
			List<Student> students = dao.getStudents();
			for (Student student : students) {
				System.out.println(student);
			}
		} catch (DataAccessException ex) {
			ex.getMessage();
			ex.printStackTrace();
		}

		/*
		 * Below is for quering the Student
		 */
		
		/*Student student = dao.getStudent(2);
		System.out.println(student);*/
		
		
		/*
		 * Below is for deleting the Student
		 */
		
		/*boolean deleteStudent = dao.deleteStudent(2);
		if (deleteStudent) {
			System.out.println("Student deleted successfully");
		}*/
		
		/*
		 * Below is for creating the Student
		 */
		
		/*Student newStudent = new Student(10,"saikat","saikat@gmail.com");
		boolean createStudent = dao.createStudent(newStudent);
		if(createStudent)
		{
			System.out.println("Student created Sucessfully");
		}*/
		
		/*
		 * The below code will create a batch of Students
		 */
		
		List<Student> newStudents = new ArrayList<Student>();
		Student student1 = new Student(3,"RamNew","ramnew@gmail.com");
		Student student2 = new Student(2,"ShyamNew","shyamnew@gmail.com");
		newStudents.add(student1);
		newStudents.add(student2);
		int[] createStudents = dao.createStudents(newStudents);
		System.out.println("No of students created "+createStudents.length);
		
		Student updateStudent = new Student(1,"new Sailat","newsaikat@gmail.com");
		int count = dao.updateStudent(updateStudent);
		System.out.println("no of student updated is "+count);

		context.close();

	}

}
