package com.blog.apis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.apis.payloads.UserDto;
import com.blog.apis.services.UserServices;

@RestController
@RequestMapping("/api/users")
public class UserController {
 @Autowired
 private UserServices userServices;
 
 @PostMapping("/") 
 public ResponseEntity<UserDto> creatUser(@RequestBody UserDto userDto){
	  UserDto creatUserDto=this.userServices.createUser(userDto);
	  return new ResponseEntity<>(creatUserDto,HttpStatus.CREATED);
	  
  }
 
}
