package com.app.dto;

import com.app.entities.Role;

public class UsersRespDTO{
	private String firstName;
	private String lastName;
	private String email;
	
	private Role role;
	private String mobile_number;
	
	/*
	 {"firstName":"Mathuresh","lastName":"Yadav","email":"m@gmail.com","password":"satyajeet","role":"CUSTOMER","mobile_number":"1234567890",}*/
	
	
	public UsersRespDTO() {
		super();
		System.out.println("in ctor "+getClass().getName());
	}


	public UsersRespDTO(String firstName, String lastName, String email, Role role, String mobile_number) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public String getMobile_number() {
		return mobile_number;
	}


	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	

}
