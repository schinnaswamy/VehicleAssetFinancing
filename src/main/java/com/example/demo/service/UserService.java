package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;

/**
 * User Service Interface
 * 
 * @author Suresh Chinnaswamy
 *
 */
public interface UserService {

	UserDto getUserById(Integer userId);

	void saveUser(UserDto userDto);

	List<UserDto> getAllUsers();

	Integer authenticate(UserDto userDto);
}
