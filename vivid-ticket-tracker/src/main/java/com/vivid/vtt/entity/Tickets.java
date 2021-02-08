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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.vivid.vtt.lookup.Status;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
public class Tickets extends BaseEntity {
	
	@Id
	@Setter(AccessLevel.NONE)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tickets_seq")
	@SequenceGenerator(name = "tickets_seq",sequenceName = "tickets_seq", initialValue = 1001, allocationSize = 1)
	private long ticketId;
	private String referenceTitle;
	private String logLocation;
	private String caseNo;
	private String incidentDesc;
	private String serialNo;
	private String machineType;
	

	private Status status;		//enum
	private String remarks;
	
	//private List<WorkLog> workLog;
	@ManyToOne
	@JoinColumn(name = "userId")
	private User engineerAssinged;
	
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	@JoinTable(name="ticket_skill",
		joinColumns=@JoinColumn(name="ticketId"), inverseJoinColumns=@JoinColumn(name="skillId"))
	private List<Skills> skills; //multiselect   
	
	@OneToMany(mappedBy = "tickets", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<WorkLog> workLog;
	
	// created by and updated by in a new class - base class
}
