package com.vivid.vtt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.vivid.vtt.dto.UserDto;
import com.vivid.vtt.entity.User;

@Mapper//(uses = { DateMapper.class })
public interface UserMapper {
	
	UserMapper instance = Mappers.getMapper(UserMapper.class);

	UserDto userToUserDto(User user);

}
