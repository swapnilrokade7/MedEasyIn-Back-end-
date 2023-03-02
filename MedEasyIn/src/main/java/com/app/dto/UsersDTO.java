package com.app.dto;

import com.app.entities.Role;

public class UsersDTO{
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Role role;
	private Long mobile_number;
	
	/*
	 {"firstName":"Mathuresh","lastName":"Yadav","email":"m@gmail.com","password":"satyajeet","role":"CUSTOMER","mobile_number":"1234567890",}*/
	
	
	public UsersDTO() {
		super();
		System.out.println("in ctor "+getClass().getName());
	}


	public UsersDTO(String firstName, String lastName, String email, String password, Role role, Long mobile_number) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.mobile_number = mobile_number;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public Long getMobile_number() {
		return mobile_number;
	}


	public void setMobile_number(Long mobile_number) {
		this.mobile_number = mobile_number;
	}
	
	


	
	
	
	
	
	

}
