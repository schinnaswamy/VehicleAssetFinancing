package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FinanceDto;
import com.example.demo.exceptions.VehicleAssetFinanceException;

/**
 * Rest resource responsible for Vehicle Asset Finance operation
 * 
 * @author Suresh Chinnaswamy
 *
 */
@RestController
public class VehicleAssetFinancingController {

	@RequestMapping(value = "/vehiclefinance/details", method = RequestMethod.GET)
	public Integer getVehiceAssetFinanceDetails(@RequestParam("months") Integer repaymentMonths,
			@RequestParam("amount") Integer financedAmount, @RequestParam("payment") Integer monthlyPayment,
			@RequestParam("selectedOption") Integer selectedFinanceOption) {

		// If selectedFinanceOption = 1 then calculate monthly payment
		if (selectedFinanceOption != null && selectedFinanceOption == 1) {
			monthlyPayment = (Integer) (financedAmount / repaymentMonths);
			System.out.println("Monthly Payment : " + monthlyPayment);

			if (monthlyPayment != null) {
				if ((Integer) monthlyPayment < 208 || (Integer) monthlyPayment > 16666) {
					throw new VehicleAssetFinanceException(
							"Monthly payment minimum should be 208 Euros and Maximum should be 16666 Euros");
				}
			}

			return (Integer) monthlyPayment;
		}

		// If selectedFinanceOption = 2 then calculate re-payment months
		else if (selectedFinanceOption != null && selectedFinanceOption == 2) {
			repaymentMonths = (Integer) (financedAmount / monthlyPayment);

			if (repaymentMonths != null) {
				if ((Integer) repaymentMonths < 6 || (Integer) repaymentMonths > 48) {
					throw new VehicleAssetFinanceException("repayment Months should lies between 4  and 48 months");
				}
			}
			return (Integer) repaymentMonths;
		}

		// If selectedFinanceOption = 3 then calculate financed amount
		else if (selectedFinanceOption != null && selectedFinanceOption == 3) {
			financedAmount = (Integer) (monthlyPayment * repaymentMonths);
			if (financedAmount != null) {
				if ((Integer) financedAmount < 10000 || (Integer) financedAmount > 100000) {
					throw new VehicleAssetFinanceException("Financed Amount should be between 10000 - 100000 Euros");
				}
			}
			return (Integer) financedAmount;
		}

		return null;
	}

	@RequestMapping(value = "vehiclefinance/details/approval", method = RequestMethod.POST)
	public String completeVehicleFinanceDeal(@RequestBody FinanceDto financeDto) {

		// TODO : Need to persist the details in the database against the user

		return "Vehicle Financing Deal completed successfully for the user";
	}

}
