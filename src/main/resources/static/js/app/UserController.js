'use strict'

var module = angular.module('demo.controllers', []);
module
		.controller(
				"UserController",
				[
						"$scope",
						"$window",
						"$location",
						"UserService",
						function($scope, $window, $location, UserService) {

							$scope.userDto = {
								userName : null,
								password : null,
								isLoginFailed : false,
								responseData : null
							};
							
							
							$scope.authenticate = function() {
								
								$scope.userDto.isLoginFailed = false;
								$scope.userDto.responseData = null;

								UserService
										.authenticate($scope.userDto)
										.then(
												function(value) {
													console.log(value.data);
													if (!value.data) {
														$scope.userDto.isLoginFailed = true;
														$scope.userDto.responseData = "User Login attempt Failed..";
														
													} else {
														var userId = value.data;
														UserService.setUserId(userId);
														$window.location
																.assign("http://localhost:8085/vehiclefinance");
													}

												});

							}

						} ]);
