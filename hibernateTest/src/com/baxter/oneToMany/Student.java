package com.baxter.oneToMany;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="STUDENT")

public class Student {
	@Id
	@Column(name="STUDENT_ID")
	@GeneratedValue
	private int stuId;
	
	@Column(name="STUDENT_NAME")
	private String stuName;
	
	@Column(name="STUDENT_EMAIL")
	private String stuEmail;
	
	@ManyToOne()
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department;
	
	public Student()
	{
		
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuEmail() {
		return stuEmail;
	}

	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
}
