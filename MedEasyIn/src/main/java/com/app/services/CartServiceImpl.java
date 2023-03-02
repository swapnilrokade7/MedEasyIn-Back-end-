package com.app.services;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Carts;
import com.app.entities.Users;
import com.app.repository.CartRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public Carts addCart(Users user) {
		Carts cart = new Carts();
		cart.setCreated(LocalDate.now() );
		cart.setUpdated(LocalDate.now());
		cart.setUser(user);
		return cartRepository.save(cart);
	}
	

	
}
