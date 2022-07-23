package com.blog.apis.services;

import java.util.List;

import com.blog.apis.payloads.CategoryDto;

public interface CategoryServices {
	CategoryDto createCategory(CategoryDto categoryDto);
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	CategoryDto getCategoryById(Integer categoryId);
	List<CategoryDto> getAllCategories();
	void deleteCategory(Integer categoryId);
	
	

}
