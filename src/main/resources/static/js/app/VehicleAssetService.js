'use strict'

angular.module('demo.services', []).factory(
		'VehicleAssetService',
		[
				"$http",
				"CONSTANTS",
				function($http, CONSTANTS) {

					var service = {};

					service.getVehicleFinanceDetails = function(months, amount,
							payment, financeOption) {
						return $http.get('vehiclefinance/details?months='
								+ months + "&amount=" + amount + "&payment="
								+ payment + "&selectedOption=" + financeOption)
					}

					service.completeVehicleFinanceDeal = function(financeDto) {
						return $http.post('vehiclefinance/details/approval',
								financeDto);
					}

					return service;
				} ]);