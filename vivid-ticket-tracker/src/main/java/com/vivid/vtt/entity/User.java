package com.vivid.vtt.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
public class User {//extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
	@SequenceGenerator(name = "users_seq",sequenceName = "users_seq", initialValue = 1001, allocationSize = 1)
	private long userId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String mobileNo;
	private String timeZone;
	
	private String username;
	private String password;
	private String userRole;
	private boolean userEnabled;

	
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	@JoinTable(name="user_skill",
		joinColumns=@JoinColumn(name="userId"), inverseJoinColumns=@JoinColumn(name="skillId"))
	private List<Skills> skills;
	@OneToMany(mappedBy = "engineerAssinged", orphanRemoval = false, fetch = FetchType.LAZY)
	private List<Tickets> tickets;
	
	@OneToMany(mappedBy = "user")
	private List<WorkLog> workLog;
	
	

}
