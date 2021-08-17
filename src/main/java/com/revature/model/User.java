package com.revature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id	// primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//about the same as auto_incerment
	private int id;
	
	@Column(name = "username", length = 50)
	private String username;
	
	@Column(name = "password", length = 50)
	private String password;
	
	@Column(name = "fName", length = 50)	// optional
	private String fName;

	@Column(name = "lName", length = 50)
	private String lName;
	
	@Column(name = "email", length = 80)
	private String email;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public User( String username, String password, String fName, String lName, String email) {
		super();
		this.username = username;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
	}




	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public int hashCode() {
		return Objects.hash(email, fName, id, lName, password, username);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(fName, other.fName) && id == other.id
				&& Objects.equals(lName, other.lName) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", fName=" + fName + ", lName="
				+ lName + ", email=" + email + "]";
	}
	
	

}