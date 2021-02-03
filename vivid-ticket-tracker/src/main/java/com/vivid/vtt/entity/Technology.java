package com.vivid.vtt.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Technology {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "technology_seq")
	@SequenceGenerator(name = "technology_seq",sequenceName = "technology_seq", initialValue = 1, allocationSize = 1)
	private long techId;
	private String techName;
	
	@OneToMany(mappedBy = "technology")
	private List<Skills> skills;
	
	private String createdDate;
	private String createdBy;

}
