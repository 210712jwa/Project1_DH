package com.revature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reimbursementType")
public class ReimbursementType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "reimbType")
	private String reimbType;
	

	public ReimbursementType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimbursementType(String reimbType) {
		super();
		this.reimbType = reimbType;
	}

	public String getReimbType() {
		return reimbType;
	}

	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(reimbType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementType other = (ReimbursementType) obj;
		return Objects.equals(reimbType, other.reimbType);
	}

	@Override
	public String toString() {
		return "ReimbursementType [reimbType=" + reimbType + "]";
	}
}
