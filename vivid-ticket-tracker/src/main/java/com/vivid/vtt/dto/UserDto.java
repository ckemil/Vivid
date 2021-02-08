package com.vivid.vtt.dto;

import java.util.List;


import com.vivid.vtt.entity.Skills;
import com.vivid.vtt.entity.Tickets;
import com.vivid.vtt.entity.WorkLog;
import com.vivid.vtt.mapper.UserMapperImpl;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class UserDto {//extends BaseDto {
	
	private long userId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String mobileNo;
	private String timeZone;
	
	private String username;
	private String password;
	private String userRole;
	
	private List<SkillsDto> skills;
	private List<TicketsDto> tickets;
	private List<WorkLogDto> workLog;
	
	
	
}
