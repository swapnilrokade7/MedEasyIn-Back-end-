package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.CartItems;

public interface CartItemsRepository extends JpaRepository<CartItems,Long> {

}
