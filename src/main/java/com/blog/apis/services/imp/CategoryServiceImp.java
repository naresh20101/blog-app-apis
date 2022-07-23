package com.blog.apis.services.imp;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.blog.apis.entities.Category;
import com.blog.apis.exceptions.ResourceNotFoundException;
import com.blog.apis.payloads.CategoryDto;
import com.blog.apis.repositories.CategoryRepo;
import com.blog.apis.services.CategoryServices;

public class CategoryServiceImp  implements CategoryServices{
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		Category cat=this.modelMapper.map(categoryDto,Category.class);
		Category addedCategory=this.categoryRepo.save(cat);
		
		return this.modelMapper.map(addedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","categoryId", categoryId));
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updaedCategory=this.categoryRepo.save(cat);
		
		return this.modelMapper.map(updaedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId",categoryId));
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", categoryId));
		this.categoryRepo.delete(cat);
	}

}
