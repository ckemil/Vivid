package com.vivid.vtt.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.vivid.vtt.entity.Tickets;
import com.vivid.vtt.entity.User;
import com.vivid.vtt.lookup.Status;

import lombok.Data;

@Data
public class WorkLogDto extends BaseDto {

private long workLogId;
	
	
	@Enumerated(EnumType.STRING)
	private Status status;		//enum
	

	private String action;
		
	
	private String remarks;
	private boolean reviewStatus; 	//approved or not
	private TicketsDto tickets;
	private UserDto user;
}
