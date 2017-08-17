package com.baxter.manyToMany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="LEADER")
public class Leader {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LEADER_ID")
	private int leader_id;
	
	@Column(name="LEADER_NAME")
	private String leader_name;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="LEADER_MEETING", 
			joinColumns={@JoinColumn(name="LEADER_ID")},									
			inverseJoinColumns={@JoinColumn(name="MEETING_ID")})
	private Set<Meeting> meetings= new HashSet<Meeting>();
	
	public Leader()
	{
		
	}
	
	public Leader(String name)
	{
		this.leader_name=name;
	}

	public int getLeader_id() {
		return leader_id;
	}

	public void setLeader_id(int leader_id) {
		this.leader_id = leader_id;
	}

	public String getLeader_name() {
		return leader_name;
	}

	public void setLeader_name(String leader_name) {
		this.leader_name = leader_name;
	}

	public Set<Meeting> getMeetings() {
		return meetings;
	}

	public void setMeetings(Set<Meeting> meetings) {
		this.meetings = meetings;
	}
	
	
	
	

}
