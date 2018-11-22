'use strict'

angular.module('demo.services', []).factory('UserService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			var userId;
			service.getUserById = function(userId) {
				var url = CONSTANTS.getUserByIdUrl + userId;
				return $http.get(url);
			}
			
			
			service.authenticate = function(userDto) {
				return $http.post('user/authenticate', userDto);
			}
			
			service.setUserId = function(data) {
			   userId = data;
			}
			
			service.getUserId = function() {
				return userId;
			}
			
			return service;
		} ]);