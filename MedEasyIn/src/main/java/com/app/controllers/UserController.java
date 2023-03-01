package com.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Users;
import com.app.services.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> userRegistration(@RequestBody @Valid Users user) {
		System.out.println("in reg user : user " );
		// invoke service layer method , for saving : user info + associated roles info
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUserDetails(user));
	}
	
	
	

}
