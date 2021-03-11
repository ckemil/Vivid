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

@Entity
@Data
public class Technology extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "technology_seq")
	@SequenceGenerator(name = "technology_seq",sequenceName = "technology_seq", initialValue = 1, allocationSize = 1)
	private long techId;
	private String techName;
	
	@OneToMany(mappedBy = "technology")
	private List<Skill> skill;
	
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	@JoinTable(name="ticket_tech",
		joinColumns=@JoinColumn(name="techId"), inverseJoinColumns=@JoinColumn(name="ticketId"))
	private List<Ticket> ticket;
	

}
