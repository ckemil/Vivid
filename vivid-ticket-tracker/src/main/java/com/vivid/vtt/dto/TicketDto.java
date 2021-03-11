package com.vivid.vtt.dto;

import java.util.List;

import com.vivid.vtt.lookup.Status;

import lombok.Data;

@Data
public class TicketDto extends BaseDto{

	private long ticketId;
	private String referenceTitle;
	private String logLocation;
	private String caseNo;
	private String incidentDesc;
	private String serialNo;
	private String machineType;

	private Status status;		//enum
	private String remarks;

	private UserDto engineerAssinged;
	
//	private List<SkillDto> skills; //multiselect   
	private List<TechnologyDto> tech;
	private List<WorkLogDto> workLog;
}
