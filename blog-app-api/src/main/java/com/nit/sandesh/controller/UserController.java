package com.nit.sandesh.controller;

import java.util.List;
import java.util.Map;

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

import com.nit.sandesh.payloads.ApiResponse;
import com.nit.sandesh.payloads.UserDto;
import com.nit.sandesh.service.IUserService;

import lombok.val;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private IUserService userservice;

	// POST- Create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createUserDto = this.userservice.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}

	// PUT update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,
			@PathVariable("userId") Integer uid) {
		UserDto updatedUser = this.userservice.updateUser(userDto, uid);
		return ResponseEntity.ok(updatedUser);

	}

	// DELETE - delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@Valid @PathVariable("userId") Integer uid) {
		this.userservice.deleteUser(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successufully", true), HttpStatus.OK);
	}

	// GET - get user;
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser() {
		return ResponseEntity.ok(this.userservice.getAllUser());
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@Valid @PathVariable Integer userId) {
		return ResponseEntity.ok(this.userservice.getUserById(userId));
	}
}
