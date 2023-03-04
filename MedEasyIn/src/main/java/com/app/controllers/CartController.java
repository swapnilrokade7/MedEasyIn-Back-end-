package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.services.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	
	@DeleteMapping("/{cartId}")
	public ResponseEntity<String> emptyTheCart(@PathVariable Long cartId) {
		cartService.emptyTheCart(cartId);

		return new ResponseEntity<String>("Cart is Empty", HttpStatus.CREATED);
	}
	
	@GetMapping("/{cartId}")
	public ResponseEntity<?> getMyCart(@PathVariable Long cartId) {
		

		return new ResponseEntity<>(cartService.getMyCart(cartId), HttpStatus.CREATED);
	}
	
}
