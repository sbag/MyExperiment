package com.baxter.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name="Parrot")
@PrimaryKeyJoinColumn(name="id")
public class Parrot extends Bird{
	
	@Column(name="color")
	private String color;
	@Column(name="singing_style")
	private boolean canSing;
	
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isCanSing() {
		return canSing;
	}
	public void setCanSing(boolean canSing) {
		this.canSing = canSing;
	}
	

	

}
