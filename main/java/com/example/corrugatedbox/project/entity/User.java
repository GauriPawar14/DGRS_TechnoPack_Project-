package com.example.corrugatedbox.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	
	
	@Column(name="First_Name",nullable=false)
	
	private String fname;
	
	
	@Column(name="Last_Name",nullable=false)
	
	private String lname;
	
	
	
	@Column(name="Email",nullable=false)
	private String email;
	
	
	@Column(name="User_Name",nullable=false,unique=true)
	private String username;
	
	
	@Column(name="Password",nullable=false)
	
	private String password;
	
	public enum Role{
		USER,
		ADMIN
	}

	@Enumerated(EnumType.STRING)
	private Role role;

	

	public User(int user_id, String fname, String lname, String email, String username, String password, Role role) {
		super();
		this.user_id = user_id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", username="
				+ username + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
	

	
	
	
	
	

}
