package com.revature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
//signify this class should be mapped to a table


@Entity
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	
	@Column(name = "userRole")
	private String role;
	
	@OneToOne
	@JoinColumn(name = "username") // improvement: could use (cascade = {})	// optional name for foreign key
	// @JsonManagedReference
	private User user;
//	@OneToMany(mappedBy = "ship", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRole(String role, User user) {
		super();
		this.role = role;
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(role, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		return Objects.equals(role, other.role) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "UserRole [role=" + role + ", user=" + user + "]";
	}
	
	
}