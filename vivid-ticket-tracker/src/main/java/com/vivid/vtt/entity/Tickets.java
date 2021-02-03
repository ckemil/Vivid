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

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
public class Tickets {
	
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
	
	private String createdDate;
	private String createdBy;
	private String updateDate;
	private String updatedBy;
	private Status status;		//enum
	private String remarks;
	
	//private List<WorkLog> workLog;
	@ManyToOne
	@JoinColumn(name = "userId")
	private Users engineerAssinged;
	
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	@JoinTable(name="ticket_skill",
		joinColumns=@JoinColumn(name="ticketId"), inverseJoinColumns=@JoinColumn(name="skillId"))
	private List<Skills> Skills; //multiselect
	
	@OneToMany(mappedBy = "tickets")
	private List<WorkLog> workLog;
	
	
}