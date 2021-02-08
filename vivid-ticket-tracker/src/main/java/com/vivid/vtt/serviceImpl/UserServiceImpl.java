package com.vivid.vtt.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vivid.vtt.dto.UserDto;
import com.vivid.vtt.dto.common.ResponseDto;
import com.vivid.vtt.entity.User;
import com.vivid.vtt.mapper.UserMapper;
import com.vivid.vtt.repository.UserRepository;
import com.vivid.vtt.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserMapper userMapper;

	@Override
	public ResponseDto<UserDto> getAll() {
		
		List<User> us = userRepo.findAll();
		System.out.println(us.toString());
		
		List<UserDto> users =us.stream().map(user -> {
			return userMapper.userToUserDto(user);
		}).collect(Collectors.toList());
		System.out.println("*********************______________*****************************");
		System.out.println(users.toString());
		return new ResponseDto<UserDto>("Sucess", "message", users);
		
		
	}

}
