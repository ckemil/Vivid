package com.vivid.vtt.service;

import com.vivid.vtt.dto.TechnologyDto;
import com.vivid.vtt.dto.common.ResponseDto;
import com.vivid.vtt.entity.Technology;

public interface TechnologyService {
	
	public ResponseDto<TechnologyDto> getAll();
	
	public ResponseDto<TechnologyDto> getOne(long id);
	
	public ResponseDto<TechnologyDto> create(Technology tech);
	
	public ResponseDto<TechnologyDto> update(Technology tech,long id);
	
	public ResponseDto<TechnologyDto> delete(long id);

}
