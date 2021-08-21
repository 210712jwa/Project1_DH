package com.revature.model;


import java.sql.Timestamp;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reimbursement")
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
	
	@Column(name = "reimbRecipe")
	private int reimbRecipe;	
//	@OneToMany(mappedBy = "ship", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })

	@ManyToOne
	@JoinColumn(name = "AuthorId", nullable = false)
	private User reimbAuthor;
	
	@ManyToOne
	@JoinColumn(name = "resolverId")
	private User reimbResolver;
	
	@ManyToOne
	@JoinColumn(name = "statusId")
	private ReimbursementStatus reimbStatus;
	
	@ManyToOne
	@JoinColumn(name = "reimbTypeId")
	private User reimbType;

	public Reimbursement(double d, Timestamp timestamp, Timestamp timestamp2, String string, int i) {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved, String reimbDiscription,
			int reimbRecipe, User reimbAuthor, User reimbResolver, ReimbursementStatus reimbStatus, User reimbType) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDiscription = reimbDiscription;
		this.reimbRecipe = reimbRecipe;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}

	

	public Reimbursement(double amount, Timestamp timestampcreated, String timestampresolved, String string) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getReimbRecipe() {
		return reimbRecipe;
	}

	public void setReimbRecipe(int reimbRecipe) {
		this.reimbRecipe = reimbRecipe;
	}

	public User getReimbAuthor() {
		return reimbAuthor;
	}

	public void setReimbAuthor(User reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	public User getReimbResolver() {
		return reimbResolver;
	}

	public void setReimbResolver(User reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	public ReimbursementStatus getReimbStatus() {
		return reimbStatus;
	}

	public void setReimbStatus(ReimbursementStatus pending) {
		this.reimbStatus = pending;
	}

	public User getReimbType() {
		return reimbType;
	}

	public void setReimbType(User reimbType) {
		this.reimbType = reimbType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, reimbAmount, reimbAuthor, reimbDiscription, reimbRecipe, reimbResolved, reimbResolver,
				reimbStatus, reimbSubmitted, reimbType);
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
		return id == other.id && Double.doubleToLongBits(reimbAmount) == Double.doubleToLongBits(other.reimbAmount)
				&& Objects.equals(reimbAuthor, other.reimbAuthor)
				&& Objects.equals(reimbDiscription, other.reimbDiscription) && reimbRecipe == other.reimbRecipe
				&& Objects.equals(reimbResolved, other.reimbResolved)
				&& Objects.equals(reimbResolver, other.reimbResolver) && Objects.equals(reimbStatus, other.reimbStatus)
				&& Objects.equals(reimbSubmitted, other.reimbSubmitted) && Objects.equals(reimbType, other.reimbType);
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", reimbAmount=" + reimbAmount + ", reimbSubmitted=" + reimbSubmitted
				+ ", reimbResolved=" + reimbResolved + ", reimbDiscription=" + reimbDiscription + ", reimbRecipe="
				+ reimbRecipe + ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver + ", reimbStatus="
				+ reimbStatus + ", reimbType=" + reimbType + "]";
	}

	public void setReimbStatus(User test123) {
		// TODO Auto-generated method stub
		
	}

	public void setType(ReimbursementType travel) {
		// TODO Auto-generated method stub
		
	}
	
	
}

	