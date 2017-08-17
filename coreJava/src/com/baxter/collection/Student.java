package com.baxter.collection;

public class Student implements Comparable<Student>{

	int age;
	String name;
	int rollNo;
	
	public Student(int age,String name,int rollNo)
	{
		this.age=age;
		this.name=name;
		this.rollNo=rollNo;
	}
	public int compareTo(Student o) {
		if(name==o.name)
		return 0;
		else if(age<o.age)
			return 1;
		else
			return -1;
	}
	
	

}
