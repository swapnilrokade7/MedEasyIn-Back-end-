package com.app.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.CartItemRespDTO;
import com.app.entities.CartItems;
import com.app.entities.Carts;
import com.app.entities.Products;
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

	@Override
	public List<CartItemRespDTO> getMyCart(Long cartId) {
		Carts cart=cartRepository.getReferenceById(cartId);
		List<CartItemRespDTO> tempList = new ArrayList<CartItemRespDTO>();
		cart.getCartItems().forEach(x->{
			Products prod=x.getProductId();
			tempList.add(new CartItemRespDTO(x.getQuantity(), x.getTotalPrice(), x.getCartId().getId(), x.getProductId().getId()));
		});
		
		return tempList ;
	}
	

	
}
