package com.vivid.vtt.service;

import com.vivid.vtt.dto.UserDto;
import com.vivid.vtt.dto.common.ResponseDto;
import com.vivid.vtt.entity.User;

public interface UserService {

	public ResponseDto<UserDto> getAll();
	
	public ResponseDto<UserDto> getOne(long id);

	public ResponseDto<UserDto> create(User user);

	public ResponseDto<UserDto> update(User user, long id);

	public ResponseDto<UserDto> delete(long id);

}
