package com.vivid.vtt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivid.vtt.dto.TechnologyDto;
import com.vivid.vtt.dto.common.ResponseDto;
import com.vivid.vtt.entity.Technology;
import com.vivid.vtt.service.TechnologyService;

@RestController
@RequestMapping("/technology")
public class TechnologyController {
	
	@Autowired
	TechnologyService techService;
	
	@GetMapping("/all")
	ResponseDto<TechnologyDto> list(){
		return techService.getAll();
	}
	@GetMapping("/{id}")
	ResponseDto<TechnologyDto> getTechnology(@PathVariable(value = "id") long id){
		return techService.getOne(id);
	}
	
	@PostMapping("/new")
	ResponseDto<TechnologyDto> create(@RequestBody Technology tech){
		return techService.create(tech);
	}
	@PutMapping("/{id}")
	ResponseDto<TechnologyDto> update(@PathVariable(value = "id") long id, @RequestBody Technology tech){
		return techService.update(tech, id);
	}
	@DeleteMapping("/{id}")
	ResponseDto<TechnologyDto> delete(@PathVariable(value = "id") long id){
		return techService.delete(id);
	}

}
