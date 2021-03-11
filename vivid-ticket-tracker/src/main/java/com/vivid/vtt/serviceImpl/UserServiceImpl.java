package com.vivid.vtt.serviceImpl;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
	//UserMapperImpl el;
	
//	@Autowired
//	MessageSource messageSource;

	@Override
	public ResponseDto<UserDto> getAll() {

		List<UserDto> users =userRepo.findAll().stream().map(user -> {
			return userMapper.userToUserDto(user);
		}).collect(Collectors.toList());
		return new ResponseDto<UserDto>("Sucess", "message", users);
		
		
	}

	@Override
	public ResponseDto<UserDto> getOne(long id) {
		
		UserDto user = userMapper.userToUserDto(userRepo.findByUserId(id));
		return new ResponseDto<UserDto>("success","message",user);
	}

	@Override
	public ResponseDto<UserDto> create(User user) {
		userRepo.save(user);
		
		//String success = messageSource.getMessage("create.user.success", new Object[] {user.getFirstName()}, Locale.ENGLISH);
		return new ResponseDto<>("sucess","User id : "+user.getUserId(),null);
	}

	@Override
	public ResponseDto<UserDto> update(User user, long id) {
		if(userRepo.findByUserId(id) != null) {
			user.setUserId(id);
			userRepo.save(user);
			return new ResponseDto<>("success","success update",null);
		}
		return null;
	}

	@Override
	public ResponseDto<UserDto> delete(long id) {
		if(userRepo.findByUserId(id) != null) {
			userRepo.delete(userRepo.findByUserId(id));
		} //  else throw exception
	
			return new ResponseDto<>("success","delete msg",null);
	}

}
