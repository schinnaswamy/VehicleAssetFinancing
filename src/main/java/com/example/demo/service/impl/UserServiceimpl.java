package com.example.demo.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDto getUserById(Integer userId) {
		//return UserConverter.entityToDto(userRepository.getOne(userId));
		return null;
	}

	@Override
	public void saveUser(UserDto userDto) {
		//userRepository.save(UserConverter.dtoToEntity(userDto));
	}

	@Override
	public List<UserDto> getAllUsers() {
		//return userRepository.findAll().stream().map(UserConverter::entityToDto).collect(Collectors.toList());
		return null;
	}

	@Override
	public Integer authenticate(UserDto userDto) {
		List<User> userList = userRepository.findAll();
		for(User user : userList) {
			if(userDto.getUserName().equalsIgnoreCase(user.getUserName()) && userDto.getPassword().equalsIgnoreCase(user.getPassword())) {
				return user.getUserId();
			}
		}
		return null;
	}
}
