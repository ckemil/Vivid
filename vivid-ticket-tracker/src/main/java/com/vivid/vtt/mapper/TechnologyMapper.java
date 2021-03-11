package com.vivid.vtt.mapper;

import org.mapstruct.Mapper;

import com.vivid.vtt.dto.TechnologyDto;
import com.vivid.vtt.entity.Technology;

@Mapper
public interface TechnologyMapper {
	
	TechnologyDto toDto(Technology tech);
	
	Technology fromDto(TechnologyDto techDto);

}
