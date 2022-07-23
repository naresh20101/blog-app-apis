package com.blog.apis.payloads;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;


public class CategoryDto {
	private Integer categoryId;
    @NotBlank
	@Size(min=4, message="The minimum character is 4!!")
	private String categoryTitle;
	@NotBlank
	@Size(min=14, message="The minimum character is 14 !!!")
	private String categoryDescription;
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public CategoryDto(Integer categoryId, String categoryTitle, String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
	}
	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
