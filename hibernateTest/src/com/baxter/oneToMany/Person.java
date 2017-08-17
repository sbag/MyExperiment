package com.baxter.oneToMany;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="PERSON")

public class Person {
	
	@Id
	@Column(name="PERSON_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int personId;
	
	@Column(name="PERSON_NAME")
	private String personName;
	
	@OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
	private Set<Phone> phoneNumbers;
	
	public Person()
	{
		
	}
	
	public Person(String name)
	{
		this.personName = name;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Set<Phone> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<Phone> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	

}
