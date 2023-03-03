package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CartItemDTO;
import com.app.services.CartItemsService;

@RestController
@RequestMapping("/cartitem")
@ResponseBody
public class CartItemController {
	
	@Autowired
	private CartItemsService cartItemsService;
	
	@PostMapping
	public ResponseEntity<?> addToCart(@RequestBody CartItemDTO cartItem) {
		System.out.println(cartItem);
//		CartItems cartItems=cartItemsService.addToCart(cartItem);

		return new ResponseEntity<>(cartItemsService.addToCart(cartItem), HttpStatus.CREATED);
	}
	
	
	
	

	
}
