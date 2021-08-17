package com.revature.model;


import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Reimbursement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "reimbAmount")
	private double reimbAmount;
	
	@Column(name = "reimbSubmitted")
	private Timestamp reimbSubmitted = new Timestamp(System.currentTimeMillis());
	
	@Column(name = "reimbResolved")
	private Timestamp reimbResolved = new Timestamp(System.currentTimeMillis());
	
	@Column(name = "reimbDiscription")
	private String reimbDiscription;	
	
//	@OneToMany(mappedBy = "ship", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })



	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Reimbursement(double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
			String reimbDiscription) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDiscription = reimbDiscription;
	}

	public double getReimbAmount() {
		return reimbAmount;
	}
	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}
	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}
	public void setReimbSubmitted(Timestamp reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}
	public Timestamp getReimbResolved() {
		return reimbResolved;
	}
	public void setReimbResolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}
	public String getReimbDiscription() {
		return reimbDiscription;
	}
	public void setReimbDiscription(String reimbDiscription) {
		this.reimbDiscription = reimbDiscription;
	}
	@Override
	public int hashCode() {
		return Objects.hash(reimbAmount, reimbDiscription, reimbResolved, reimbSubmitted);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		return Double.doubleToLongBits(reimbAmount) == Double.doubleToLongBits(other.reimbAmount)
				&& Objects.equals(reimbDiscription, other.reimbDiscription)
				&& Objects.equals(reimbResolved, other.reimbResolved)
				&& Objects.equals(reimbSubmitted, other.reimbSubmitted);
	}
	@Override
	public String toString() {
		return "Reimburement [reimbAmount=" + reimbAmount + ", reimbSubmitted=" + reimbSubmitted + ", reimbResolved="
				+ reimbResolved + ", reimbDiscription=" + reimbDiscription + "]";
	}
	
	
}
