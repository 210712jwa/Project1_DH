package com.revature.dto;

import java.sql.Blob;
import java.util.Objects;

public class EditReimbursementDTO {

	private int status;

	public EditReimbursementDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EditReimbursementDTO(int status) {
		super();
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}

