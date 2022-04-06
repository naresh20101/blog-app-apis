package com.blog.apis.services;

import java.util.List;

import com.blog.apis.payloads.UserDto;

public interface UserServices {

	UserDto createUser (UserDto user);
	UserDto updateUser (UserDto user, Integer userId);
	UserDto getuserById(Integer userId);
	List<UserDto> getAllusers();
	void deleteuser(Integer userId);
}
