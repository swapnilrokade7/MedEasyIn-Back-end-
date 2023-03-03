package com.app.services;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Carts;
import com.app.entities.Users;
import com.app.repository.CartItemsRepository;
import com.app.repository.CartRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartItemsService cartItemsService;
	
	@Override
	public Carts addCart(Users user) {
		Carts cart = new Carts();
		cart.setCreated(LocalDate.now() );
		cart.setUpdated(LocalDate.now());
		cart.setUser(user);
		return cartRepository.save(cart);
	}

	@Override
	public void emptyTheCart(Long cartId) {
		Carts cart=cartRepository.getReferenceById(cartId);
		cart.emptyCartItems();
		cart.setTotalItems(0);
		cart.setTotalPrice(0);
		cart.setUpdated(LocalDate.now());
		
		cartItemsService.DeleteCartItemsFromCart(cart);
		
	}
	

	
}
