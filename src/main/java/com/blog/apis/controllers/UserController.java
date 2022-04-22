package com.blog.apis.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.apis.payloads.ApiResponse;
import com.blog.apis.payloads.UserDto;
import com.blog.apis.services.UserServices;

@RestController
@RequestMapping("/api/users")
public class UserController {
 @Autowired
 private UserServices userServices;
 
 @PostMapping("/") 
 public ResponseEntity<UserDto> creatUser(@Valid @RequestBody UserDto userDto){
	  UserDto creatUserDto=this.userServices.createUser(userDto);
	  return new ResponseEntity<>(creatUserDto,HttpStatus.CREATED);
	  
  }
 @PutMapping("/{userId}")
 public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uId){
	 UserDto updatedUser=this.userServices.updateUser(userDto, uId);
	 
	 return ResponseEntity.ok(updatedUser);
 }
 @DeleteMapping("/{userId}")
 public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uId)
 {
	 this.userServices.deleteuser(uId);
	 return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted Successfully", true),HttpStatus.OK);
 }
 @GetMapping("/")
 public ResponseEntity<List<UserDto> >getAllUsers()
 {
	 return ResponseEntity.ok(this.userServices.getAllusers());
 }
 @GetMapping("/{userId}")
 public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Integer uId)
 {
	 return ResponseEntity.ok(this.userServices.getuserById(uId));
 }
}
