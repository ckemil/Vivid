package com.vivid.vtt.dto;

import java.util.List;

import com.vivid.vtt.lookup.Status;

import lombok.Data;

@Data
public class TicketsDto extends BaseDto {

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
	
	private List<SkillsDto> skills; //multiselect   
	
	private List<WorkLogDto> workLog;
}
