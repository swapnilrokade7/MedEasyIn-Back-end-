package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CartItemDTO;
import com.app.services.CartItemsService;
import com.app.services.CartService;

@RestController
@RequestMapping("/cart")
public class CartIController {
	
	@Autowired
	private CartService cartService;
	
	
	@DeleteMapping("/{cartId}")
	public ResponseEntity<String> emptyTheCart(@PathVariable Long cartId) {
		cartService.emptyTheCart(cartId);

		return new ResponseEntity<String>("Cart is Empty", HttpStatus.CREATED);
	}
	

	
}
