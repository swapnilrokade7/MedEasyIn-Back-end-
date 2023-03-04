package com.app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DeliveryAddressDTO;
import com.app.entities.Orders;
import com.app.repository.OrderRepository;
import com.app.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	

	
	
	@PostMapping("/{userId}")
	public ResponseEntity<?> placeOrder(@PathVariable Long userId ,@RequestBody DeliveryAddressDTO address )
	{	
		return new ResponseEntity<>(orderService.placeOrder(userId,address), HttpStatus.CREATED);
	} 
	
	
	@GetMapping
	public ResponseEntity<?> getAllOrders()
	{	
		
		return new ResponseEntity<>( orderService.getAllOrders(),HttpStatus.CREATED);
	} 
	
	@GetMapping("/{custId}")
	public ResponseEntity<?> getMyOrders(@PathVariable Long custId)
	{	
		
		return new ResponseEntity<>( orderService.getMyOrders(custId),HttpStatus.CREATED);
	} 
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable Long orderId)
	{	
		
		orderService.deleteOrder(orderId);
		return new ResponseEntity<String>( "Order Deleted",HttpStatus.CREATED);
	} 
	

}
