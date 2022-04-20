package com.nit.sandesh.service;

import java.util.List;

import com.nit.sandesh.payloads.PostDto;

public interface IPostService {
	//create
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//update
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//delete 
	void deletePost(Integer postId);
	
	//get one post
	PostDto getpostById(Integer postId);
	
	//get all post
	List<PostDto> getAllPost();
	
	//get post by category
	List<PostDto> getPostByCategory(Integer categoryId);
	
	//get all post by user
	List<PostDto> getPostByUser(Integer userId);
	
	//search post
	List<PostDto> searchPost(String keyword);
	

}
