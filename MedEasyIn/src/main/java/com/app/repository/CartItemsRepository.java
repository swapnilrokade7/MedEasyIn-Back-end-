package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.CartItems;
import com.app.entities.Carts;

public interface CartItemsRepository extends JpaRepository<CartItems,Long> {
	
	@Modifying
	@Query("delete CartItems ci where ci.cartId=?1")
	void deleteByCartId(Carts cartId);
	

}
