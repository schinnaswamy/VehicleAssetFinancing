package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.service.UserService;
import com.example.demo.utils.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This REST resource is responsible for User related operation
 * 
 * @author suresh chinnaswamy
 *
 */
@Api(value = "/user")
@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	UserService userService;

	/**
	 * Authenticate user
	 * 
	 * @param userDto
	 * @return
	 */
	@ApiOperation(value = "authenticate", response = Integer.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User Details Authenticated", response = Integer.class),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "User not found")

	})

	@RequestMapping(value = Constants.AUTHENTICATE, method = RequestMethod.POST)
	public Integer authenticate(@RequestBody UserDto userDto) {
		if (userDto.getUserName() == null || userDto.getPassword() == null) {
			throw new UserNotFoundException("UserName and Password is mandatory");
		}
		return userService.authenticate(userDto);
	}

	/**
	 * Get all users
	 * 
	 * @return
	 */

	@ApiOperation(value = "getAllUsers", response = Integer.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User Details Retrieved", response = List.class),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "UserDetails not found")

	})

	@RequestMapping(value = Constants.GET_ALL_USERS,method = RequestMethod.GET)
	public List<UserDto> getAllUsers() {
		return userService.getAllUsers();
	}

	/**
	 * Save User
	 * 
	 * @param userDto
	 */
	@ApiOperation(value = "save user")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "User Details saved"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "UserDetails not found")

	})
	@RequestMapping(value = Constants.SAVE_USER, method = RequestMethod.POST)
	public void saveUser(@RequestBody UserDto userDto) {
		userService.saveUser(userDto);
	}
}
