package com.vivid.vtt.dto;

import java.util.List;

import lombok.Data;

@Data
public class TechnologyDto extends BaseDto {

	private long techId;
	private String techName;
	
	private List<SkillsDto> skills;
	
}
