package com.baxter.oneToMany;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="DEPARTMENT")

public class Department {
	
	@Id
	@Column(name="DEPARTMENT_ID")
	@GeneratedValue
	private int deptId;
	@Column(name="DEPARTMENT_NAME")
	private String deptName;
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	private Set<Student> students;
	
	public Department()
	{
		
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	
}
