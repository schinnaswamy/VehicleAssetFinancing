package com.example.demo.dto;

public class FinanceDto {

	private Integer months;
	private Integer amount;
	private Integer payment;
	boolean isValidDetails;

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getPayment() {
		return payment;
	}

	public void setPayment(Integer payment) {
		this.payment = payment;
	}

	public boolean isValidDetails() {
		return isValidDetails;
	}

	public void setValidDetails(boolean isValidDetails) {
		this.isValidDetails = isValidDetails;
	}

}
