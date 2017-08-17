package com.baxter.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class StudentDemo {

	public static void main(String[] args) {
		Student stu1 = new Student(35,"Sourav",1);
		Student stu2 = new Student(30,"Saikat",2);
		Student stu3 = new Student(34,"Saonli",3);
		
		List<Student> stuList = new ArrayList<Student>();
		stuList.add(stu1);
		stuList.add(stu2);
		stuList.add(stu3);
		
		Collections.sort(stuList);
		
		for(Student st:stuList)
		{
			System.out.println("Age: "+st.age+" Name:"+st.name+" RollNo:"+st.rollNo);
		}
		
		
		
		
	}

}
