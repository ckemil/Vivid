package com.vivid.vtt.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserDto extends BaseDto {
	
	private long userId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String mobileNo;
	private String timeZone;
	
	private String username;
	private String password;
	private String userRole;
	private boolean userEnabled;
	
	private List<SkillDto> skill;
	private List<TicketDto> ticket;
	private List<WorkLogDto> workLog;
	
	
	
}
