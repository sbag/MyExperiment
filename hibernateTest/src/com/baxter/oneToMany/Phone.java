package com.baxter.oneToMany;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Table(name="Phone")

public class Phone {
	@Id
	@Column(name="PHONE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int phoneId;
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	private Person person;
	
	public Phone()
	{
		
	}

	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
	
}
