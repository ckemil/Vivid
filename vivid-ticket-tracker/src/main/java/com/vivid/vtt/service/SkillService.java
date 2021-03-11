package com.vivid.vtt.service;

import com.vivid.vtt.dto.SkillDto;
import com.vivid.vtt.dto.common.ResponseDto;
import com.vivid.vtt.entity.Skill;

public interface SkillService {

	public ResponseDto<SkillDto> getAll();
	
	public ResponseDto<SkillDto> getOne(long id);
	
	public ResponseDto<SkillDto> create(Skill skill);
	
	public ResponseDto<SkillDto> update(Skill skill, long id);
	
	public ResponseDto<SkillDto> delete(long id);
}
