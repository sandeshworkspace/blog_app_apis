package com.nit.sandesh.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nit.sandesh.config.AppConstant;
import com.nit.sandesh.payloads.ApiResponse;
import com.nit.sandesh.payloads.PostDto;
import com.nit.sandesh.payloads.PostResponse;
import com.nit.sandesh.service.IFileService;
import com.nit.sandesh.service.IPostService;

@RestController
@RequestMapping("/api/")
public class PostController {

	@Autowired
	private IPostService postService;
	
	@Autowired
	private IFileService fileService;
	
	@Value("${project.image}")
	private String path;

	// create controller
	@PostMapping("/users/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
	}

	// get by user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId) {
		List<PostDto> posts = this.postService.getPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}

	// get by Category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId) {
		List<PostDto> posts = this.postService.getPostByCategory(categoryId);
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
	}

	// get all post
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value = "pageNumber", defaultValue = AppConstant.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstant.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstant.SORT_BY, required = false) String sortBy,
			@RequestParam(value="sortDir", defaultValue = AppConstant.SORT_DIR,required = false) String sortDir) {
		PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize, sortBy,sortDir);
		return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
	}

	// get post details by id
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {
		PostDto postDtos = this.postService.getpostById(postId);
		return new ResponseEntity<PostDto>(postDtos, HttpStatus.OK);
	}

	// delete post
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId) {
		this.postService.deletePost(postId);
		return new ApiResponse("post is successfully deleted", true);
	}

	// delete post
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {
		PostDto updatedPost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatedPost, HttpStatus.OK);
	}

	// search apis in post controller
	
	@GetMapping("/posts/search/{keywords}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable("keywords") String keywords){
		List<PostDto> result= this.postService.searchPost(keywords);
		return new ResponseEntity<List<PostDto>>(result,HttpStatus.OK);
	}
	
	//post image upload
	
	@PostMapping("/post/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadPostImage(@RequestParam ("image") MultipartFile image,
			@PathVariable Integer postId) throws IOException{
		PostDto postDto = this.postService.getpostById(postId);
		String fileName = this.fileService.uploadImage(path, image);
		postDto.setImageName(fileName);
		PostDto updatedPost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatedPost,HttpStatus.OK);
	}
	
	//method to serve image in springboot project
	
	public void downloadImage(@PathVariable ("imageName") String imageName,
			HttpServletResponse response)throws IOException {
		InputStream resource = this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
	}

}
