package com.vivid.vtt.dto;

import java.util.List;
import lombok.Data;

@Data
public class SkillsDto {

	private long skillId;
	private String skillName;
	
	private TechnologyDto technology;
	
	private List<UserDto> user;
	
	private List<TicketsDto> tickets;
}
