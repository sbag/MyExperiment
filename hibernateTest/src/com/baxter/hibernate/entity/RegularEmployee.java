package com.baxter.hibernate.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="regularEmployee")
@AttributeOverrides(
		{
			@AttributeOverride(name="id",column=@Column(name="id")),
			@AttributeOverride(name="name",column=@Column(name="name"))
		})
public class RegularEmployee extends Employee{
	
	@Column(name="bonus")
	private double bonus;
	
	@Column(name="salary")
	private double salary;
	
	public RegularEmployee()
	{
		
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	

}
