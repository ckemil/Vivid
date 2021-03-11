package com.vivid.vtt.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivid.vtt.dto.SkillDto;
import com.vivid.vtt.dto.common.ResponseDto;
import com.vivid.vtt.entity.Skill;
import com.vivid.vtt.mapper.SkillMapper;
import com.vivid.vtt.repository.SkillRepository;
import com.vivid.vtt.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {
	
	@Autowired
	SkillRepository skillRepo;
	
	@Autowired
	SkillMapper mapper;
	
	@Override
	public ResponseDto<SkillDto> getAll() {
		List<SkillDto> skills = skillRepo.findAll().stream().map(skill -> {
			return mapper.toDto(skill);
		}).collect(Collectors.toList());
		return new ResponseDto<SkillDto>("message","success",skills);
	}

	@Override
	public ResponseDto<SkillDto> getOne(long id) {
		Skill skill = skillRepo.findById(id).get();  // nee to change orElse thorw exce
		
		return new ResponseDto<SkillDto>("message","success",mapper.toDto(skill));
	}

	@Override
	public ResponseDto<SkillDto> create(Skill skill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDto<SkillDto> update(Skill skill, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDto<SkillDto> delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
