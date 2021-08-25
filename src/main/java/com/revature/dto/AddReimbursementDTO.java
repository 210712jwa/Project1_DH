package com.revature.dto;

public class AddReimbursementDTO {

	private double amount;
	private String discription;
	private int type;

	public AddReimbursementDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddReimbursementDTO(double amount, String discription, int type) {
		super();
		this.amount = amount;
		this.discription = discription;
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	

}
