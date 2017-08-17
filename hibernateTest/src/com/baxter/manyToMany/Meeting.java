package com.baxter.manyToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="MEETING")
public class Meeting {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MEETING_ID")
	private int meeting_id;
	
	@Column(name="MEETING_NAME")
	private String meeting_name;
	
	@ManyToMany(mappedBy="meetings")
	private Set<Leader> leaders = new HashSet<Leader>();
	
	public Meeting()
	{
		
	}
	
	public Meeting(String name)
	{
		this.meeting_name=name;
	}

	public int getMeeting_id() {
		return meeting_id;
	}

	public void setMeeting_id(int meeting_id) {
		this.meeting_id = meeting_id;
	}

	public String getMeeting_name() {
		return meeting_name;
	}

	public void setMeeting_name(String meeting_name) {
		this.meeting_name = meeting_name;
	}

	public Set<Leader> getLeaders() {
		return leaders;
	}

	public void setLeaders(Set<Leader> leaders) {
		this.leaders = leaders;
	}
	
	
}
