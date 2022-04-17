package com.nit.sandesh.controller;

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
import com.nit.sandesh.payloads.ApiResponse;
import com.nit.sandesh.payloads.CategoryDto;
import com.nit.sandesh.service.ICategeryService;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private ICategeryService service;
	
	//Create 
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
		CategoryDto createCategory = this.service.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
	}
	
	//update 
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Integer catId){
		CategoryDto updatedCategory = this.service.updateCategory(categoryDto,catId);
		return new ResponseEntity<CategoryDto>(updatedCategory,HttpStatus.OK);
	}
	
	
	//delete 
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
		this.service.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted sucessfully !!!",true),HttpStatus.OK);
	}
	
	
	//get one 
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCatagory(@PathVariable Integer catId){
		CategoryDto  categoryDto =  this.service.getCategory(catId);
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
	}
	
	//get all
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCatagory(){
		List<CategoryDto>  categoryDto1 =  this.service.getAllCategory();
		//return new ResponseEntity<List<CategoryDto>>(categoryDto,HttpStatus.OK);
		return ResponseEntity.ok(categoryDto1);
	}
	
}
