package com.blog.apis.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.apis.entities.User;
import com.blog.apis.payloads.UserDto;
import com.blog.apis.repositories.UserRepo;
import com.blog.apis.services.UserServices;

public class UserSeviceImp implements UserServices {
	@Autowired
   private UserRepo userRepo;
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user=this.dtoToUser(userDto);
		User savedUser=this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getuserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllusers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteuser(Integer userId) {
		// TODO Auto-generated method stub
		
	}
	private User dtoToUser(UserDto userDto) {
	    User user = new User();
	    user.setId(userDto.getId());
	    user.setName (userDto.getName ());
	    user.setEamil(userDto.getEmail());
	    user.setAbout (userDto.getAbout ());
	    user.setPassword(userDto.getPassword());
	    return user;
	}
	public UserDto userToDto(User user) {
	    UserDto userDto = new UserDto();
	    userDto.setId(user.getId());
	    userDto.setName (user.getName ());
	    userDto.setEmail(user.getEamil());
	    userDto.setPassword(user.getPassword());
	    userDto.setAbout (user.getAbout ());
	    return userDto;

}
}
