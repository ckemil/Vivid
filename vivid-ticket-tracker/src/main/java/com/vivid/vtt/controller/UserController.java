package com.vivid.vtt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivid.vtt.dto.UserDto;
import com.vivid.vtt.dto.common.ResponseDto;
import com.vivid.vtt.entity.User;
import com.vivid.vtt.mapper.UserMapperImpl;
import com.vivid.vtt.repository.UserRepository;
import com.vivid.vtt.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	UserService userService;
	

	@GetMapping("/all")
	ResponseDto<UserDto> listUser(){
		return userService.getAll();
	}
	
		
	@GetMapping("/{id}")
	ResponseDto<UserDto> getUser(@PathVariable(value = "id") long id){
		return userService.getOne(id);
	}
	
	@PostMapping
	ResponseDto<UserDto> createUser(@RequestBody User user){
		return userService.create(user);
	}
	
	@PutMapping("/{id}")
	ResponseDto<UserDto> updateUser(@PathVariable(value = "id") long id, @RequestBody User user){
		return userService.update(user, id);
	}
	
	@DeleteMapping("/{id}")
	ResponseDto<UserDto> deleteUser(@PathVariable(value = "id") long id){
		return userService.delete(id);
	}


}
