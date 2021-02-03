package com.vivid.vtt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class WorkLog {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workLog_seq")
	@SequenceGenerator(name = "workLog_seq",sequenceName = "workLog_seq", initialValue = 1001, allocationSize = 1)
	private long workLogId;
	
	@ManyToOne
	@JoinColumn(name = "ticketId")
	private Tickets tickets;
	
	private Status status;		//enum
	
	private String startTime;
	private String endTime;
	private String action;
		
	private String createdDate;
	private String createdBy;
	
	private String remarks;
	private boolean reviewStatus = false; 	//approved or not
	@ManyToOne
	@JoinColumn(name = "Approver")
	private Users users;
}
