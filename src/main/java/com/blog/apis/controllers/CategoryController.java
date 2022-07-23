package com.blog.apis.controllers;

import java.util.List;

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
import com.blog.apis.payloads.CategoryDto;
import com.blog.apis.services.CategoryServices;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private CategoryServices categoryServices;
	
	
	
	 @PostMapping("/")
	 
	 public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
		 CategoryDto catDto=this.categoryServices.createCategory(categoryDto);
		 return new ResponseEntity<CategoryDto>(catDto,HttpStatus.OK);
	 }
	
	//@GetMapping("/")
	//public ResponseEntity<List<CategoryDto>> 

 @PutMapping("/{categId}")
	 
	 public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId){
		 CategoryDto catDto=this.categoryServices.updateCategory(categoryDto,categoryId);
		 return new ResponseEntity<CategoryDto>(catDto,HttpStatus.OK);
	 }
 @DeleteMapping("/{categId}")	
 public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
	 this.categoryServices.deleteCategory(categoryId);
	 return new ResponseEntity<ApiResponse>(new ApiResponse("successfully deleted", true),HttpStatus.OK);
 }
 @GetMapping("/{categId}")
 public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
	CategoryDto cat =this.categoryServices.getCategoryById(categoryId);
	 return new ResponseEntity<CategoryDto>(cat,HttpStatus.OK);
 }
 @GetMapping("/")
 public ResponseEntity<List<CategoryDto>> getCategories(){
	 List<CategoryDto> categories=this.categoryServices.getAllCategories();
	//CategoryDto cat =this.categoryServices.getCategoryById(categoryId);
	 return ResponseEntity.ok(categories);
 }
 
}
