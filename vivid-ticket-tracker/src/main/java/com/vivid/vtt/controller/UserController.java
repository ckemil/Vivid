package com.vivid.vtt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vivid.vtt.dto.UserDto;
import com.vivid.vtt.dto.common.ResponseDto;
import com.vivid.vtt.entity.User;
import com.vivid.vtt.repository.UserRepository;
import com.vivid.vtt.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/all")
	ResponseDto<UserDto> list(){
		return userService.getAll();
	}
	
	@GetMapping("/list")
	List<User> getAllUser(){
		List<User> user = userRepo.findAll();
		return user;
	}

}
