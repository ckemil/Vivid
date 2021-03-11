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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skills_seq")
	@SequenceGenerator(name = "skills_seq",sequenceName = "skills_seq", initialValue = 101, allocationSize = 1)
	private long skillId;
	private String skillName;
	
	@ManyToOne
	@JoinColumn(name="techId")
	private Technology technology;
	
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	@JoinTable(name="user_skill",
		joinColumns=@JoinColumn(name="skillId"), inverseJoinColumns=@JoinColumn(name="userId"))
	private List<User> user;
	
	
	

}
