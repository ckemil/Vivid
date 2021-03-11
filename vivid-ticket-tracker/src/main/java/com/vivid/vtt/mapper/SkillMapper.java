package com.vivid.vtt.mapper;

import org.mapstruct.Mapper;

import com.vivid.vtt.dto.SkillDto;
import com.vivid.vtt.entity.Skill;

@Mapper
public interface SkillMapper {
	
	Skill formDto(SkillDto skillDto);
	
	SkillDto toDto(Skill skill);
}
