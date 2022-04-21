package com.blog.apis.services.imp;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.apis.entities.User;
import com.blog.apis.exceptions.ResourceNotFoundException;
import com.blog.apis.payloads.UserDto;
import com.blog.apis.repositories.UserRepo;
import com.blog.apis.services.UserServices;
@Service
public class UserSeviceImp implements UserServices {
	@Autowired
   private UserRepo userRepo;
	@Autowired
    private ModelMapper mapper;
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
		User user=this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("users", "id", userId));
		user.setName(userDto.getName());
		user.setEamil(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updatedUser=this.userRepo.save(user);
		UserDto userDto1=this.userToDto(updatedUser);
		
		return userDto1;
	}

	@Override
	public UserDto getuserById(Integer userId) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("users", "id", userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllusers() {
		// TODO Auto-generated method stub
		List<User> users=this.userRepo.findAll();
		List<UserDto> userDtos=users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteuser(Integer userId) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("users", "id", userId));
		this.userRepo.delete(user);
		
	}
	private User dtoToUser(UserDto userDto) {
	    User user = this.mapper.map(userDto, User.class);
	    
	  /*  user.setId(userDto.getId());
	    user.setName (userDto.getName ());
	    user.setEamil(userDto.getEmail());
	    user.setAbout (userDto.getAbout ());
	    user.setPassword(userDto.getPassword());*/
	    return user;
	}
	public UserDto userToDto(User user) {
	    UserDto userDto = this.mapper.map(user, UserDto.class);
	   /* userDto.setId(user.getId());
	    userDto.setName (user.getName ());
	    userDto.setEmail(user.getEamil());
	    userDto.setPassword(user.getPassword());
	    userDto.setAbout (user.getAbout ());*/
	    return userDto;

}
}
