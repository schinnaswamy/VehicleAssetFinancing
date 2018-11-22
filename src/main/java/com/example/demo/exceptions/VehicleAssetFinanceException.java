package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class is responsible for handling the exception related to vehicle asset
 * financing
 * 
 * @author Suresh Chinnaswamy
 *
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class VehicleAssetFinanceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VehicleAssetFinanceException(String exceptionMessage) {
		super(exceptionMessage);
	}

}
