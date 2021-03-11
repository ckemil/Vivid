package com.vivid.vtt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vivid.vtt.dto.SkillDto;
import com.vivid.vtt.dto.common.ResponseDto;
import com.vivid.vtt.service.SkillService;

@RestController
@RequestMapping("/skill")
public class SkillController {
	
	@Autowired
	SkillService skillService;
	
	@GetMapping("/all")
	ResponseDto<SkillDto> list(){
		return skillService.getAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseDto<SkillDto> getOne(@PathVariable(value = "id") long id){
		return skillService.getOne(id);
	}
	
	

}
