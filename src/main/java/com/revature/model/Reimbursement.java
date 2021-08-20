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
	private String reimbRecipe;	
//	@OneToMany(mappedBy = "ship", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })

	@ManyToOne
	@JoinColumn(name = "AuthorId", nullable = false)
	private User author;
	
	@ManyToOne
	@JoinColumn(name = "resolverId")
	private User resolver;
	
	@ManyToOne
	@JoinColumn(name = "statusId")
	private User statusId;
	
	@ManyToOne
	@JoinColumn(name = "reimbTypeId")
	private User reimbTypeId;
	
	

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Reimbursement(int id, double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
			String reimbDiscription, String reimbRecipe, User author, User resolver, User statusId, User reimbTypeId) {
		super();
		//this.id = id;
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDiscription = reimbDiscription;
		this.reimbRecipe = reimbRecipe;
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



	public String getReimbRecipe() {
		return reimbRecipe;
	}



	public void setReimbRecipe(String reimbRecipe) {
		this.reimbRecipe = reimbRecipe;
	}



	public User getAuthor() {
		return author;
	}



	public void setAuthor(User author) {
		this.author = author;
	}



	public User getResolver() {
		return resolver;
	}



	public void setResolver(User resolver) {
		this.resolver = resolver;
	}



	public User getStatusId() {
		return statusId;
	}



	public void setStatusId(User statusId) {
		this.statusId = statusId;
	}



	public User getReimbTypeId() {
		return reimbTypeId;
	}



	public void setReimbTypeId(User reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}



	@Override
	public int hashCode() {
		return Objects.hash(author, id, reimbAmount, reimbDiscription, reimbRecipe, reimbResolved, reimbSubmitted,
				reimbTypeId, resolver, statusId);
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
		return Objects.equals(author, other.author) && id == other.id
				&& Double.doubleToLongBits(reimbAmount) == Double.doubleToLongBits(other.reimbAmount)
				&& Objects.equals(reimbDiscription, other.reimbDiscription)
				&& Objects.equals(reimbRecipe, other.reimbRecipe) && Objects.equals(reimbResolved, other.reimbResolved)
				&& Objects.equals(reimbSubmitted, other.reimbSubmitted)
				&& Objects.equals(reimbTypeId, other.reimbTypeId) && Objects.equals(resolver, other.resolver)
				&& Objects.equals(statusId, other.statusId);
	}



	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", reimbAmount=" + reimbAmount + ", reimbSubmitted=" + reimbSubmitted
				+ ", reimbResolved=" + reimbResolved + ", reimbDiscription=" + reimbDiscription + ", reimbRecipe="
				+ reimbRecipe + ", author=" + author + ", resolver=" + resolver + ", statusId=" + statusId
				+ ", reimbTypeId=" + reimbTypeId + "]";
	}

}	