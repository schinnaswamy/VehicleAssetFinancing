'use strict'

var module = angular.module('demo.controllers', []);
module.controller("VehicleAssetController", [
		"$scope",
		"$window",
		"$location",
		"VehicleAssetService",
		function($scope, $window, $location, VehicleAssetService) {
			$scope.finance = {
				option : '1'

			};
			$scope.financeDto = {
				months : 0,
				amount : 0,
				payment : 0,
				isValidDetails : false

			}

			$scope.getVehicleFinanceDetails = function() {

				$scope.financeDto.isValidDetails = false;

				VehicleAssetService.getVehicleFinanceDetails(
						$scope.financeDto.months, $scope.financeDto.amount,
						$scope.financeDto.payment, $scope.finance.option).then(
						function(value) {
							console.log(value.data);
							if (value.data) {

								if ($scope.finance.option == 1) {
									$scope.financeDto.payment = value.data;
								} else if ($scope.finance.option == 2) {
									$scope.financeDto.months = value.data;
								} else if ($scope.finance.option == 3) {
									$scope.financeDto.amount = value.data;
								}
								$scope.financeDto.isValidDetails = true;
							}

						}, function onError(error) {
							console.log("Unknown error");
							$window.alert(error.data.message);

						}

				);

			}

			$scope.resetFields = function() {
				$scope.financeDto.months = 0;
				$scope.financeDto.amount = 0;
				$scope.financeDto.payment = 0;
			}

			$scope.completeVehicleFinanceDeal = function() {

				VehicleAssetService.completeVehicleFinanceDeal(
						$scope.financeDto).then(function(value) {
					console.log("Deal successfull...");
					$window.alert("Deal successfull...");
				}, function onError(error) {
					console.log("Unknown error");
				});
			}

		} ]);
