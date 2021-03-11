package com.vivid.vtt.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivid.vtt.dto.TechnologyDto;
import com.vivid.vtt.dto.common.ResponseDto;
import com.vivid.vtt.entity.Technology;
import com.vivid.vtt.mapper.TechnologyMapper;
import com.vivid.vtt.repository.TechnologyRepository;
import com.vivid.vtt.service.TechnologyService;

@Service
public class TechnologyServiceImpl implements TechnologyService{
	
	@Autowired
	TechnologyRepository techRepo; 
	@Autowired
	TechnologyMapper mapper;

	@Override
	public ResponseDto<TechnologyDto> getAll() {
		
		List<TechnologyDto> techDto = techRepo.findAll().stream().map(tech -> {
			return mapper.toDto(tech);
		}).collect(Collectors.toList());
		
		return new ResponseDto<TechnologyDto>("Success","messaggee",techDto);
	}

	@Override
	public ResponseDto<TechnologyDto> getOne(long id) {
		Technology tech = techRepo.findById(id).get();  //need to change .get() to .orElse and throw error
		TechnologyDto techDto = mapper.toDto(tech);
		return new ResponseDto<TechnologyDto>("success","message",techDto);
		
	}

	@Override
	public ResponseDto<TechnologyDto> create(Technology tech) {
		techRepo.save(tech);
		return new ResponseDto<>("sucess", "Tech id " +tech.getTechId(),null);
	}

	@Override
	public ResponseDto<TechnologyDto> update(Technology tech, long id) {
		
		if(techRepo.findById(id)!=null) {
			tech.setTechId(id);
			techRepo.save(tech);
			return new ResponseDto<>("success","updated tech "+id,null);
		}
		return new ResponseDto<>("Failed","ticket id invalid",null);
	}

	@Override
	public ResponseDto<TechnologyDto> delete(long id) {
		if(techRepo.findById(id)!=null) {
			techRepo.deleteById(id);
			return new ResponseDto<>("success","updated tech "+id,null);
		}
		return new ResponseDto<>("Failed","ticket id invalid",null);
	}

}
