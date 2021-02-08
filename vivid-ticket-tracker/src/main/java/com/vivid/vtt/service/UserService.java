package com.vivid.vtt.service;

import com.vivid.vtt.dto.UserDto;
import com.vivid.vtt.dto.common.ResponseDto;

public interface UserService {

	public ResponseDto<UserDto> getAll();
}
