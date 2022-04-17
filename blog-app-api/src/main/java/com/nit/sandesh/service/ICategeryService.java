package com.nit.sandesh.service;

import java.util.List;

import com.nit.sandesh.payloads.CategoryDto;

public interface ICategeryService {

	// create
	CategoryDto createCategory(CategoryDto categoryDto);

	// update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

	// delete
	void deleteCategory(Integer categoryId);

	// get
	CategoryDto getCategory(Integer categoryId);

	// get all
	List<CategoryDto> getAllCategory();

}
