package com.app.services;

import java.util.List;
import java.util.Set;

import com.app.dto.CartItemRespDTO;
import com.app.entities.CartItems;
import com.app.entities.Carts;
import com.app.entities.Users;

public interface CartService {

	Carts addCart(Users user);

	void emptyTheCart(Long cartId);

//	List<CartItemRespDTO> getMyCart(Long cartId);
	
	Carts getMyCart(Long cartId);

}
