package com.nit.sandesh.service;

import java.util.List;

import com.nit.sandesh.payloads.UserDto;

public interface IUserService {

	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto userDto, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUser();

	void deleteUser(Integer userId);

}
