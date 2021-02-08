package com.vivid.vtt.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.vivid.vtt.lookup.Status;

import lombok.Data;

@Entity
@Data
public class WorkLog extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workLog_seq")
	@SequenceGenerator(name = "workLog_seq",sequenceName = "workLog_seq", initialValue = 1001, allocationSize = 1)
	private long workLogId;
	
	
	@Enumerated(EnumType.STRING)
	private Status status;		//enum
	private String action;
		
	private String remarks;
	private boolean reviewStatus = false; 	//approved or not
	@ManyToOne
	@JoinColumn(name = "ticketId")
	private Tickets tickets;
	@ManyToOne
	@JoinColumn(name = "approver")
	private User user;
}
